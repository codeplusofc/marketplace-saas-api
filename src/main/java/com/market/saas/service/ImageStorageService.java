package com.market.saas.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.*;

@Service
public class ImageStorageService {

    private final Path root = Paths.get("uploads");

    public String saveImage(MultipartFile file) {
        try {

            if (!Files.exists(root)) {
                Files.createDirectories(root);
            }


            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();


            Files.copy(file.getInputStream(), this.root.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);

            return fileName;
        } catch (IOException e) {
            throw new RuntimeException("Não foi possível salvar a imagem: " + e.getMessage());
        }
    }
}