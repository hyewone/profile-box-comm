package com.goorm.profileboxcomm.dto.link.response;

import com.goorm.profileboxcomm.entity.Link;
import lombok.Data;

@Data
public class SelectLinkResponseDto {
    private Long linkId;
    private String link;
    private String linkName;
    private String createDt;

    public SelectLinkResponseDto(Link link) {
        this.linkId = link.getLinkId();
        this.link = link.getLink();
        this.linkName = link.getLinkName();
        this.createDt = link.getCreateDt().toString();
    }
}
