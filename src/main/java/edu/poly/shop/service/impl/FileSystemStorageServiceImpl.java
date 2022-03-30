package edu.poly.shop.service.impl;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.annotation.Resource;

import org.springframework.core.io.UrlResource;
import org.springframework.web.multipart.MultipartFile;

import edu.poly.shop.config.StorageProperties;
import edu.poly.shop.exception.StorageException;
import edu.poly.shop.exception.StorageFileNotFoundException;
import edu.poly.shop.service.StorageService;

public class FileSystemStorageServiceImpl implements StorageService {

    private final Path rootLocation;

    public String getStoredFilename(MultipartFile file , String id) {
        String ext = FilenameUtils.getExtension(file.getOriginalFilename());
        return "p" + id + "." + ext;
    }

    public FileSystemStorageServiceImpl(StorageProperties properties) {
        this.rootLocation = Paths.get(properties.getLocation());
    }
    
    public void store(MultipartFile file , String storedFilename){
        try {
            if (file.isEmpty()) {
                throw new StorageException("Failed to store empty file " + file.getOriginalFilename());
            }
            Path dest = this.rootLocation.resolve(Paths.get(storedFilename)).normalize().toAbsolutePath();
            if(!dest.getParent().equals(this.rootLocation.toAbsolutePath())){
                throw new StorageException("Invalid file path");
            }
            try(InputStream inputStream = file.getInputStream()){
                Files.copy(inputStream, dest, StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (Exception e) {
            throw new StorageException("Failed to store file");
        }
    }

    public Resource loadAsResource(String filename) {
        try {
            Path file = load(filename);
            Resource resource = (Resource) new UrlResource(file.toUri());
            if(resource.exists() || resource.isReadable()){
                return resource;
            }else{
                throw new StorageFileNotFoundException("File not found : "+ filename);
            }
        } catch (Exception e) {
            throw new StorageException("Failed to load file");
        }
    }
}
