package com.goorm.profileboxcomm.dto.filmo.response;

import com.goorm.profileboxcomm.entity.Filmo;
import com.goorm.profileboxcomm.enumeration.FilmoType;
import lombok.Data;

@Data
public class SelectFilmoResponseDto {
    private Long filmoId;
    private FilmoType filmoType;
    private String filmoName;
    private String filmoYear;
    private String filmoDirector;
    private String createDt;
//    private SelectImageResponseDto filmoImage;

    public SelectFilmoResponseDto(Filmo filmo) {
        this.filmoId = filmo.getFilmoId();
        this.filmoType = filmo.getFilmoType();
        this.filmoName = filmo.getFilmoName();
        this.filmoYear = filmo.getFilmoYear();
        this.filmoDirector = filmo.getFilmoDirector();
        this.createDt = filmo.getCreateDt().toString();
//        this.filmoImage = (filmo.getFilmoImage() != null) ? new SelectImageResponseDto(filmo.getFilmoImage()) : new SelectImageResponseDto();
    }
}