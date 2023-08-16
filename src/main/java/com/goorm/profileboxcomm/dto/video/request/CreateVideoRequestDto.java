package com.goorm.profileboxcomm.dto.video.request;

import lombok.Data;

@Data
public class CreateVideoRequestDto {
    private String fileName;
    private String fileRealName;
    private String filePath;

    public CreateVideoRequestDto(String fileName, String fileRealName, String filePath) {
        this.fileName = fileName;
        this.fileRealName = fileRealName;
        this.filePath = filePath;
    }
}
