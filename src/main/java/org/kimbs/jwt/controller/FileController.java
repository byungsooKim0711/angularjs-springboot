package org.kimbs.jwt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class FileController {

    @PostMapping("/file")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile[] files) throws Exception {

        for (MultipartFile file : files) {
            System.out.println("Multipart: " + file.getName());
            System.out.println("Multipart: " + file.getContentType());
            System.out.println("Multipart: " + file.getOriginalFilename());
            System.out.println("Multipart: " + file.getBytes());
            System.out.println("Multipart: " + file.getResource());
            System.out.println("Multipart: " + file.getSize());
            System.out.println("Multipart: " + file.isEmpty());
        }

        return ResponseEntity.ok(files.length);
    }
}
