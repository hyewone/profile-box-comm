package com.goorm.profileboxcomm.entity;

import com.goorm.profileboxcomm.dto.notice.request.CreateNoticeRequestDto;
import com.goorm.profileboxcomm.enumeration.FilmoType;
import com.goorm.profileboxcomm.utils.Utils;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
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

    @Enumerated(EnumType.STRING)
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

    @Transient
    private Long likeCount;

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

    public static Notice createNotice(CreateNoticeRequestDto dto, Member member) throws ParseException {
        return Notice.builder()
                .noticeTitle(dto.getNoticeTitle())
                .noticeContent(dto.getNoticeContent())
                .filmoType(dto.getFilmoType())
                .filmoName(dto.getFilmoName())
                .filmoRole(dto.getFilmoRole())
                .applyDeadlineDt(Utils.stringToDate(dto.getApplyDeadlineDt()))
                .filmingStartPeriod(Utils.stringToDate(dto.getFilmingStartPeriod()))
                .filmingEndPeriod(Utils.stringToDate(dto.getFilmingEndPeriod()))
                .member(member)
                .build();
    }

    public static Notice updateNotice(Notice notice, CreateNoticeRequestDto dto) {
        notice.setNoticeTitle(dto.getNoticeTitle());
        notice.setNoticeContent(dto.getNoticeContent());
        notice.setFilmoType(dto.getFilmoType());
        notice.setFilmoName(dto.getFilmoName());
        notice.setFilmoRole(dto.getFilmoRole());
        notice.setApplyDeadlineDt(Utils.stringToDate(dto.getApplyDeadlineDt()));
        notice.setFilmingStartPeriod(Utils.stringToDate(dto.getFilmingStartPeriod()));
        notice.setFilmingEndPeriod(Utils.stringToDate(dto.getFilmingEndPeriod()));
        return notice;
    }

    public static List<String> getNoticeFieldNames() {
        List<String> fieldNames = new ArrayList<>();
        Class<?> profileClass = Notice.class;

        Field[] fields = profileClass.getDeclaredFields();
        for (Field field : fields) {
            fieldNames.add(field.getName());
        }

        return fieldNames;
    }
}
