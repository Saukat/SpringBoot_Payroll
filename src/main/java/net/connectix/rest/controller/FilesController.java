package net.connectix.rest.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.core.io.Resource;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

import net.connectix.document.FileInfo;
import net.connectix.document.Reimbursement;
import net.connectix.dto.ResponseMessage;
import net.connectix.service.IFilesStorageService;

@CrossOrigin(origins = "*")	
@RestController
@RequestMapping("/files")
public class FilesController {
  
	@Autowired
	IFilesStorageService storageService;
	
	@Autowired
	MongoOperations mongoOperations;
	
	@PostMapping("/upload/{id}")
	  public ResponseEntity<ResponseMessage> uploadFiles(@RequestParam("files") MultipartFile[] files,@PathVariable String id) {
	    String message = "";
	   try {
	      List<String> fileNames = new ArrayList<>();
     System.out.println("idsss"+id);
     
     
     List<String> urls = new ArrayList<>();
     
	      Arrays.asList(files).stream().forEach(file -> {
	  
	    	  
	        storageService.save(file,id);
	        fileNames.add(file.getOriginalFilename());
	        
	        
	        for (String str : fileNames) {
	        	 String fns=str.toString();
	   			String  urlss = MvcUriComponentsBuilder
	   			          .fromMethodName(FilesController.class, "getFile",str.toString()).build().toString();
	   			  System.out.println("SAve DAta Url"+urls);
	   			urls.add(urlss);
	   		}
	   
	       
	      });
	      
	      
	      
			
	      
	      Reimbursement reimbursement=new Reimbursement();
	      Query query = new Query();
	 		  query.addCriteria(Criteria.where("id").is(id));
	 		
	 		
	 		
	        System.out.println("Query:"+query);
	 		Update update = new Update();
	 		update.set("fileName", fileNames);
	 		
			update.set("filePath", urls);

	 		System.out.println("updated" + update);
	 		Reimbursement updatedData = mongoOperations.findAndModify(query, update, reimbursement.getClass());
	        System.out.println("Updated Data"+updatedData);
	      
	      message = "Uploaded the files successfully: " + fileNames;
	      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
	      
	    } catch (Exception e) {
	      message = "Fail to upload files!";
	      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
	    }
	  }
	
	
	
	
	
	 @GetMapping("/allFiles")
	  public ResponseEntity<List<FileInfo>> getListFiles() {
		 
		 
		

	    List<FileInfo> fileInfos = storageService.loadAll().map(path -> {
	    	System.out.println("Url of file"+path);
	      String filename = path.getFileName().toString();
	      String url = MvcUriComponentsBuilder
	          .fromMethodName(FilesController.class, "getFile", path.getFileName().toString()).build().toString();

//	      System.out.println(MvcUriComponentsBuilder.fromMethodName(FilesController.class, "getFile"));
	      return new FileInfo(filename, url);
	    }).collect(Collectors.toList());
	    return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
	  }
	 
	 
	 @GetMapping("/oneFiles/{id}")
	  public ResponseEntity<String> getOnetFile(@PathVariable String id) {
		 Resource fileInfos = storageService.load(id);
		 String filename = fileInfos.getFilename().toString();
		 System.out.println("filename 1"+filename);
		 String url = MvcUriComponentsBuilder
		          .fromMethodName(FilesController.class, "getFile", fileInfos.getFilename().toString()).build().toString();

		    return ResponseEntity.status(HttpStatus.OK).body(url);
		    
//		  String filename = path.getFileName().toString();
//	     Reimbursement reim = storageService.getFile(id);
//	       String filename=reim.getFileName().toString();
//
//	     String url = MvcUriComponentsBuilder
//		          .fromMethodName(FilesController.class, "getFile", reim.getFileName().toString()).build().toString();
//	     return ResponseEntity.status(HttpStatus.OK).body(new FileInfo(filename, url));
//	    
//	 
	  }

	  @GetMapping("/file/{filename:.+}")
	  public ResponseEntity<Resource> getFile(@PathVariable String filename) {
	    Resource file = storageService.load(filename);
	    System.out.println("File"+file);
	    ResponseEntity res= ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
	   System.out.println("Response Entity"+res);
	    return res;
	  }
	  
	  
	  

}
