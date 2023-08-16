package com.goorm.profileboxcomm.entity;

import com.goorm.profileboxcomm.enumeration.FilmoType;
import com.goorm.profileboxcomm.dto.notice.NoticeDTO;
import com.goorm.profileboxcomm.utils.Utils;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="notice")
public class Notice {

    @Id
    @Column(name="notice_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noticeId;

    @Column(name = "notice_title")
    @NotNull
    @NotBlank
    private String noticeTitle;

    @Column(name = "notice_content")
    @NotNull
    @NotBlank
    private String noticeContent;

    @Column(name = "filmo_type")
    @NotNull
    private FilmoType filmoType;

    @Column(name = "filmo_name")
    @NotNull
    @NotBlank
    private String filmoName;

    @Column(name = "filmo_role")
    @NotNull
    @NotBlank
    private String filmoRole;

    @Temporal(TemporalType.DATE)
    @Column(name = "apply_deadline_dt")
    @NotNull
    private Date applyDeadlineDt;

    @Temporal(TemporalType.DATE)
    @Column(name = "filming_start_period")
    @NotNull
    private Date filmingStartPeriod;

    @Temporal(TemporalType.DATE)
    @Column(name = "filming_end_period")
    @NotNull
    private Date filmingEndPeriod;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_dt")
    private LocalDateTime createDt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modify_dt")
    private LocalDateTime modifyDt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @PrePersist
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        createDt = now;
        modifyDt = now;
    }

    @PreUpdate
    protected void onModify() {
        modifyDt = LocalDateTime.now();
    }

    // method
    public static NoticeDTO toDTO(Notice entity){
        return NoticeDTO.builder()
                .noticeId(entity.getNoticeId())
                .title(entity.getNoticeTitle())
                .content(entity.getNoticeContent())
                .filmo_type(entity.getFilmoType().toString())
                .filmo_name(entity.getFilmoName())
                .filmo_role(entity.getFilmoRole())
                .apply_deadline_dt(Utils.dateToString(entity.getApplyDeadlineDt()))
                .filming_start_period(Utils.dateToString(entity.getFilmingStartPeriod()))
                .filming_end_period(Utils.dateToString(entity.getFilmingEndPeriod()))
                .create_dt(Utils.localDateToString(entity.getCreateDt()))
                .modify_dt(Utils.localDateToString(entity.getModifyDt()))
                .member_id(entity.getMember().getMemberId())
                .build();
    }

}
