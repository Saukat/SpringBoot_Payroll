package net.connectix.service.impl;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import net.connectix.document.FileDB;
import net.connectix.repo.FileDBRepository;
import net.connectix.service.IFileStorageService;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
@Service
public class FileStorageServiceImpl implements IFileStorageService{

	 @Autowired
	  private FileDBRepository fileDBRepository;

	@Override
	public FileDB store(MultipartFile file) throws IOException{
	    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
	    FileDB FileDB = new FileDB(fileName);

	    return fileDBRepository.save(FileDB);
	}

	@Override
	public FileDB getFile(String id) {
		
		return fileDBRepository.findById(id).get();
	}

	@Override
	public Stream<FileDB> getAllFiles() {
		// TODO Auto-generated method stub
		return fileDBRepository.findAll().stream();
	}

//	@Override
//	public String saveFileDB(String data) {
//		
//		return fileDBRepository.insert()
//	}

	 
}
