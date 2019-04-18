package org.softuni.onlinegrocery.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface CloudinaryService {

    String uploadImage(MultipartFile multipartFile) throws IOException;

    MultipartFile findImageByUrl(String imageUrl);
}
