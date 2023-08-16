package com.goorm.profileboxcomm.dto.image.response;

import com.goorm.profileboxcomm.entity.Image;
import lombok.Data;

@Data
public class SelectImageResponseDto {
    private Long imageId;
    private String fileName;
    private String filePath;
    private String fileRealName;
    private String createDt;
    public SelectImageResponseDto() {
    }

    public SelectImageResponseDto(Image image) {
        this.imageId = image.getImageId();
        this.fileName = image.getFileName();
        this.filePath = image.getFilePath();
        this.fileRealName = image.getFileRealName();
        this.createDt = image.getCreateDt().toString();
    }
}
