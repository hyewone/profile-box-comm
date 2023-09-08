package com.goorm.profileboxcomm.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProfile is a Querydsl query type for Profile
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProfile extends EntityPathBase<Profile> {

    private static final long serialVersionUID = -1051673339L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProfile profile = new QProfile("profile");

    public final StringPath content = createString("content");

    public final DateTimePath<java.time.LocalDateTime> createDt = createDateTime("createDt", java.time.LocalDateTime.class);

    public final NumberPath<Long> defaultImageId = createNumber("defaultImageId", Long.class);

    public final ListPath<Filmo, QFilmo> filmoEntities = this.<Filmo, QFilmo>createList("filmoEntities", Filmo.class, QFilmo.class, PathInits.DIRECT2);

    public final ListPath<Image, QImage> imageEntities = this.<Image, QImage>createList("imageEntities", Image.class, QImage.class, PathInits.DIRECT2);

    public final ListPath<Link, QLink> linkEntities = this.<Link, QLink>createList("linkEntities", Link.class, QLink.class, PathInits.DIRECT2);

    public final QMember member;

    public final DateTimePath<java.time.LocalDateTime> modifyDt = createDateTime("modifyDt", java.time.LocalDateTime.class);

    public final NumberPath<Long> profileId = createNumber("profileId", Long.class);

    public final StringPath title = createString("title");

    public final ListPath<Video, QVideo> videoEntities = this.<Video, QVideo>createList("videoEntities", Video.class, QVideo.class, PathInits.DIRECT2);

    public QProfile(String variable) {
        this(Profile.class, forVariable(variable), INITS);
    }

    public QProfile(Path<? extends Profile> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProfile(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProfile(PathMetadata metadata, PathInits inits) {
        this(Profile.class, metadata, inits);
    }

    public QProfile(Class<? extends Profile> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member"), inits.get("member")) : null;
    }

}

