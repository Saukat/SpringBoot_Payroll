package net.connectix.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;

import net.connectix.document.FileDB;

public interface IFileStorageService {
	
	 public FileDB store(MultipartFile file) throws IOException;
//	 public String saveFileDB(String data);
	 public FileDB getFile(String id);
	 public Stream<FileDB> getAllFiles();
}
