package net.connectix.service;

import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import net.connectix.document.FileDB;
import net.connectix.document.Reimbursement;

public interface IFilesStorageService {
	 public void init();

	  public void save(MultipartFile file,String id);

	  public Resource load(String filename);
	  
	  public Reimbursement getFile(String id);

	  public void deleteAll();

	  public Stream<Path> loadAll();
	  
	  
}
