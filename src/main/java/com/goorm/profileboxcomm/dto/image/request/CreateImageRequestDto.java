package com.goorm.profileboxcomm.dto.image.request;

import lombok.Data;

@Data
public class CreateImageRequestDto {

    private String fileName;
    private String filePath;
    private String fileRealName;

    public CreateImageRequestDto(String fileName, String filePath, String fileRealName) {
        this.fileName = fileName;
        this.filePath = filePath;
        this.fileRealName = fileRealName;
    }
}
