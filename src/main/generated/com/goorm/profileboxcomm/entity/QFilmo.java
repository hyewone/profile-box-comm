package com.goorm.profileboxcomm.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFilmo is a Querydsl query type for Filmo
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFilmo extends EntityPathBase<Filmo> {

    private static final long serialVersionUID = -1476520505L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QFilmo filmo = new QFilmo("filmo");

    public final DateTimePath<java.time.LocalDateTime> createDt = createDateTime("createDt", java.time.LocalDateTime.class);

    public final StringPath filmoDirector = createString("filmoDirector");

    public final NumberPath<Long> filmoId = createNumber("filmoId", Long.class);

    public final StringPath filmoName = createString("filmoName");

    public final EnumPath<com.goorm.profileboxcomm.enumeration.FilmoType> filmoType = createEnum("filmoType", com.goorm.profileboxcomm.enumeration.FilmoType.class);

    public final StringPath filmoYear = createString("filmoYear");

    public final DateTimePath<java.time.LocalDateTime> modifyDt = createDateTime("modifyDt", java.time.LocalDateTime.class);

    public final QProfile profile;

    public QFilmo(String variable) {
        this(Filmo.class, forVariable(variable), INITS);
    }

    public QFilmo(Path<? extends Filmo> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QFilmo(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QFilmo(PathMetadata metadata, PathInits inits) {
        this(Filmo.class, metadata, inits);
    }

    public QFilmo(Class<? extends Filmo> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.profile = inits.isInitialized("profile") ? new QProfile(forProperty("profile"), inits.get("profile")) : null;
    }

}

