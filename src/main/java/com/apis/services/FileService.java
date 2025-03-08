package com.apis.services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
	String uploadImages(String path, MultipartFile file) throws IOException;
	InputStream getResouces(String path, String fileName)throws FileNotFoundException;

}
