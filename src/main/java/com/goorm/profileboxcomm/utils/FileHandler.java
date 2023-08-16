package com.goorm.profileboxcomm.utils;

import com.goorm.profileboxcomm.dto.image.request.CreateImageRequestDto;
import com.goorm.profileboxcomm.dto.video.request.CreateVideoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class FileHandler {

    private final S3Uploader s3Uploader;

    @Value("${custom.storage.filePath}")
    private String FILE_UPLOAD_PATH;
    @Value("${custom.storage.imagePath}")
    private String IMAGE_UPLOAD_PATH;
    @Value("${custom.storage.videoPath}")
    private String VIDEO_UPLOAD_PATH;

    public CreateImageRequestDto imageWrite(MultipartFile file) {
        try {
            String savedDt = new SimpleDateFormat("yyyyMMdd").format(new Date());
            String savePath = FILE_UPLOAD_PATH + IMAGE_UPLOAD_PATH + savedDt;
            String origName = file.getOriginalFilename();
            String saveName = s3Uploader.generateUniqueFileName(origName);
            String savedUrl = s3Uploader.uploadMultipartFile(file, savePath + "/" + saveName);
            return new CreateImageRequestDto(saveName, savedUrl, origName);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public CreateVideoRequestDto videoWrite(MultipartFile file){
        try {
            String savedDt = new SimpleDateFormat("yyyyMMdd").format(new Date());
            String savePath = FILE_UPLOAD_PATH + VIDEO_UPLOAD_PATH + savedDt;
            String origName = file.getOriginalFilename();
            String saveName = s3Uploader.generateUniqueFileName(origName);
            String savedUrl = s3Uploader.uploadMultipartFile(file, savePath + "/" + saveName);
            return new CreateVideoRequestDto(saveName, savedUrl, origName);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public void deleteFile(String filePath){
        s3Uploader.deleteS3File(filePath);
    }
}
