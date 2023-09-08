package com.goorm.profileboxcomm.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLink is a Querydsl query type for Link
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLink extends EntityPathBase<Link> {

    private static final long serialVersionUID = 1338022430L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLink link1 = new QLink("link1");

    public final DateTimePath<java.time.LocalDateTime> createDt = createDateTime("createDt", java.time.LocalDateTime.class);

    public final StringPath link = createString("link");

    public final NumberPath<Long> linkId = createNumber("linkId", Long.class);

    public final StringPath linkName = createString("linkName");

    public final QProfile profile;

    public QLink(String variable) {
        this(Link.class, forVariable(variable), INITS);
    }

    public QLink(Path<? extends Link> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QLink(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QLink(PathMetadata metadata, PathInits inits) {
        this(Link.class, metadata, inits);
    }

    public QLink(Class<? extends Link> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.profile = inits.isInitialized("profile") ? new QProfile(forProperty("profile"), inits.get("profile")) : null;
    }

}

