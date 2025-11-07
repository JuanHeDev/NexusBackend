package com.project.nexus.controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.nexus.service.CloudinaryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Uploads")
@RestController
@RequestMapping("/upload")
@CrossOrigin(origins = "http://localhost:5173")
public class UploadController {
    
    private final CloudinaryService cloudinaryService;

    public UploadController(CloudinaryService cloudinaryService) {
        this.cloudinaryService = cloudinaryService;
    }

    @Operation(summary = "Subir imagen")
    @PostMapping
    public ResponseEntity<Map<String, String>> subirImagen(@RequestParam("file") MultipartFile file) throws IOException {
        String imageUrl = cloudinaryService.subirArchivo(file);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("url", imageUrl));
    }
}
