package com.goorm.profileboxcomm.controller;

import com.goorm.profileboxcomm.dto.image.request.CreateImageRequestDto;
import com.goorm.profileboxcomm.service.FileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/v1/")
public class FileController {

    private final FileService fileService;

    @PostMapping("/image")
    public List<CreateImageRequestDto> writeImageAndGetIamgeDto(List<@Valid MultipartFile> imageFiles){
        return fileService.writeImageAndGetIamgeDto(imageFiles);
    }

    @PostMapping("/video")
    public List<CreateImageRequestDto> writeVideoAndGetVideoDto(List<@Valid MultipartFile> imageFiles){
        return fileService.writeImageAndGetIamgeDto(imageFiles);
    }
}
