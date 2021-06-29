package net.connectix.rest.controller;



import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import net.connectix.document.FileDB;
import net.connectix.dto.ResponseFile;
import net.connectix.dto.ResponseMessage;
import net.connectix.helper.FileUploadHelper;
import net.connectix.repo.FileDBRepository;
import net.connectix.service.IFileStorageService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/file")
public class FileController {
	
	@Autowired
	private IFileStorageService storageService;
	
	@Autowired
	private FileUploadHelper fileUploadHelper;
	
	@Autowired
	private FileDBRepository repo;
	
	
	
	@PostMapping("/upload-file")
	public ResponseEntity<String> uploadFiles(@RequestParam("file") MultipartFile file){
		System.out.println("file Name:"+file.getOriginalFilename());
		System.out.println(file.getSize());
		System.out.println(file.getContentType());
		System.out.println(file.getName());
		try {
	
		if(file.isEmpty()) {
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain file");
		}

//		if(!file.getContentType().equals("image/pdf")) {
//			  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only JPEG conetent type allow");
//		}	
		//file upload code
		boolean f=fileUploadHelper.uploadFile(file);
		
		if(f) {	
			  storageService.store(file);

			return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/").path(file.getOriginalFilename()).toUriString());
		}
	
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Somthing Went Wrong! try again");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@PostMapping("/upload-file")
//	public ResponseEntity<String> uploadFiles(@RequestParam("file") MultipartFile file){
//		System.out.println("file Name:"+file.getOriginalFilename());
//		System.out.println(file.getSize());
//		System.out.println(file.getContentType());
//		System.out.println(file.getName());
//		try {
//	
//		if(file.isEmpty()) {
//          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain file");
//		}
//
////		if(!file.getContentType().equals("image/pdf")) {
////			  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only JPEG conetent type allow");
////		}	
//		//file upload code
//		boolean f=fileUploadHelper.uploadFile(file);
//		
//		if(f) {	
//			  storageService.store(file);
//
//			return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/").path(file.getOriginalFilename()).toUriString());
//		}
//	
//		}
//		
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Somthing Went Wrong! try again");
//	}
	
	
	
	
//	@PostMapping("/upload")
//	public String fileUpload(@RequestPart("file") MultipartFile file) throws IOException
//	{
//		
//		System.out.println("Saukat"+file.getName());
//		File convertFile = new File("/var/www/html/payrollFile/" + file.getOriginalFilename());
//		System.out.println("con"+convertFile);
//		convertFile.createNewFile();
//
//		try (FileOutputStream fout = new FileOutputStream(convertFile))
//		{
//			System.out.println("done"+file.getBytes());
//			fout.write(file.getBytes());
//		}
//		catch (Exception exe)
//		{
//			exe.printStackTrace();
//		}
//		return "File has uploaded successfully";
//	}
//	
	
	
	
	
	
//	@PutMapping("/fileupload")
//	public String Upload(@RequestParam(required = false) MultipartFile file) {
//		System.out.println(file.getName());
//		return "uploaded";
//	}
//	
	@PostMapping("/upload")
	  public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
	    String message = "";
	    try {
	      storageService.store(file);

	      message = "Uploaded the file successfully: " + file.getOriginalFilename();
	      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
	    } catch (Exception e) {
	      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
	      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
	    }
	  }
	
	
	
	@GetMapping("/files/{id}")
	  public ResponseEntity<byte[]> getFile(@PathVariable String id) {
	    FileDB fileDB = storageService.getFile(id);

	    return ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
	        .body(fileDB.getData());
	  }
	  
	  
	  
	  
	  @GetMapping("/files")
	  public ResponseEntity<List<ResponseFile>> getListFiles() {
	    List<ResponseFile> files = storageService.getAllFiles().map(dbFile -> {
	      String fileDownloadUri = ServletUriComponentsBuilder
	          .fromCurrentContextPath()
	          .path("/files/")
	          .path(dbFile.getId())
	          .toUriString();

	      return new ResponseFile(
	          dbFile.getName(),
	          fileDownloadUri,
	          dbFile.getType(),
	          dbFile.getData().length);
	    }).collect(Collectors.toList());

	    return ResponseEntity.status(HttpStatus.OK).body(files);
	  }
	  
	  
}
