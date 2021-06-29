package net.connectix.service.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import net.connectix.document.FileDB;
import net.connectix.document.Leave;
import net.connectix.document.Reimbursement;
import net.connectix.repo.ReimbursementRepo;
import net.connectix.service.IFilesStorageService;

@Service
public class FilesStorageServiceImpl implements IFilesStorageService{
 
	@Autowired
	ReimbursementRepo repo;
	
	@Autowired
	MongoOperations mongoOperations;
	
	private final Path root = Paths.get("uploads");

//	  private final Path dirLocation;

	  @Override
	  public void init() {
	    try {
	      Files.createDirectory(root);
	    } catch (IOException e) {
	      throw new RuntimeException("Could not initialize folder for upload!");
	    }
	  }

	  @Override
	  public void save(MultipartFile file,String id) {
//		  Reimbursement reimbursement=new Reimbursement();
	    try {
	      Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
	  
	      
	  
	      
	 
	    } catch (Exception e) {
	      throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
	    }
	  }

	  @Override
	  public Resource load(String filename) {
//	    try {
//	      Path file = root.resolve(filename);
//	      Resource resource = new UrlResource(file.toUri());
//          System.out.println("Resource"+resource);
//	      if (resource.exists() || resource.isReadable()) {
//	        return resource;
//	      } else {
//	        throw new RuntimeException("Could not read the file!");
//	      }
//	    } catch (MalformedURLException e) {
//	      throw new RuntimeException("Error: " + e.getMessage());
//	    }
		  
		// TODO Auto-generated method stub
          try {
            Path file =root.resolve(filename).normalize();
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            } 
            else {
            	 throw new RuntimeException("Could not read the file!");
            }
          } 
          catch (MalformedURLException e) {
        	  throw new RuntimeException("Could not read the file!");
          }     
	  }
	  
	  
	  @Override
		public Reimbursement getFile(String id) {
			
			return repo.findById(id).get();
		}


	  @Override
	  public void deleteAll() {
	    FileSystemUtils.deleteRecursively(root.toFile());
	  }

	  
	  @Override
	  public Stream<Path> loadAll() {
		  
	    try {
	      return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
	    } catch (IOException e) {
	      throw new RuntimeException("Could not load the files!");
	    }
	  }
}
