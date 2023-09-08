package com.goorm.profileboxcomm.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QNotice is a Querydsl query type for Notice
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QNotice extends EntityPathBase<Notice> {

    private static final long serialVersionUID = 1707313148L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QNotice notice = new QNotice("notice");

    public final DatePath<java.util.Date> applyDeadlineDt = createDate("applyDeadlineDt", java.util.Date.class);

    public final DateTimePath<java.time.LocalDateTime> createDt = createDateTime("createDt", java.time.LocalDateTime.class);

    public final DatePath<java.util.Date> filmingEndPeriod = createDate("filmingEndPeriod", java.util.Date.class);

    public final DatePath<java.util.Date> filmingStartPeriod = createDate("filmingStartPeriod", java.util.Date.class);

    public final StringPath filmoName = createString("filmoName");

    public final StringPath filmoRole = createString("filmoRole");

    public final EnumPath<com.goorm.profileboxcomm.enumeration.FilmoType> filmoType = createEnum("filmoType", com.goorm.profileboxcomm.enumeration.FilmoType.class);

    public final QMember member;

    public final DateTimePath<java.time.LocalDateTime> modifyDt = createDateTime("modifyDt", java.time.LocalDateTime.class);

    public final StringPath noticeContent = createString("noticeContent");

    public final NumberPath<Long> noticeId = createNumber("noticeId", Long.class);

    public final StringPath noticeTitle = createString("noticeTitle");

    public QNotice(String variable) {
        this(Notice.class, forVariable(variable), INITS);
    }

    public QNotice(Path<? extends Notice> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QNotice(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QNotice(PathMetadata metadata, PathInits inits) {
        this(Notice.class, metadata, inits);
    }

    public QNotice(Class<? extends Notice> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member"), inits.get("member")) : null;
    }

}

