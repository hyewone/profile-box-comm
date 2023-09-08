package com.goorm.profileboxcomm.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QVideo is a Querydsl query type for Video
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QVideo extends EntityPathBase<Video> {

    private static final long serialVersionUID = -1461752105L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QVideo video = new QVideo("video");

    public final DateTimePath<java.time.LocalDateTime> createDt = createDateTime("createDt", java.time.LocalDateTime.class);

    public final StringPath fileName = createString("fileName");

    public final StringPath filePath = createString("filePath");

    public final StringPath fileRealName = createString("fileRealName");

    public final QProfile profile;

    public final NumberPath<Long> videoId = createNumber("videoId", Long.class);

    public QVideo(String variable) {
        this(Video.class, forVariable(variable), INITS);
    }

    public QVideo(Path<? extends Video> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QVideo(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QVideo(PathMetadata metadata, PathInits inits) {
        this(Video.class, metadata, inits);
    }

    public QVideo(Class<? extends Video> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.profile = inits.isInitialized("profile") ? new QProfile(forProperty("profile"), inits.get("profile")) : null;
    }

}

