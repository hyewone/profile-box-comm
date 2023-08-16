package com.goorm.profileboxcomm.service;

import com.goorm.profileboxcomm.dto.image.request.CreateImageRequestDto;
import com.goorm.profileboxcomm.dto.video.request.CreateVideoRequestDto;
import com.goorm.profileboxcomm.utils.FileHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class FileService {

    private final FileHandler fileHandler;

    public List<CreateImageRequestDto> writeImageAndGetIamgeDto(List<MultipartFile> images){
        List<CreateImageRequestDto> imageDtoList = null;
        if (images != null & images.size() > 1) {
            imageDtoList = images.stream()
                    .map(o -> fileHandler.imageWrite(o))
                    .collect(toList());
        }
        return imageDtoList;
    }

    public List<CreateVideoRequestDto> writeVideoAndGetVideoDto(List<MultipartFile> videos){
        List<CreateVideoRequestDto> videoDtoList = null;
        if (videos != null & videos.size() > 1) {
            videoDtoList = videos.stream()
                    .map(o -> fileHandler.videoWrite(o))
                    .collect(toList());
        }
        return videoDtoList;
    }

}
