package com.blog.app.service.impl;

import com.blog.app.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {


    @Override
    public String uploadImage(String path, MultipartFile file) throws IOException {

        //file name ex: abc.png
        String name = file.getOriginalFilename();

        String randomID = UUID.randomUUID().toString();
        String fileName = randomID.concat(name.substring(name.lastIndexOf(".")));

        //Full path
        String filePth = path + File.separator + fileName;

        //create folder if not created
        File f = new File(path);
        if (!f.exists()) {
            f.mkdir();
        }

        //file copy
        Files.copy(file.getInputStream(), Paths.get(filePth));

        return fileName;
    }

    @Override
    public InputStream getResource(String path, String fileName) throws FileNotFoundException {
           String fullPath = path + File.separator + fileName;
           InputStream is = new FileInputStream(fullPath);
           return  is;
    }
}
