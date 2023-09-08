package com.goorm.profileboxcomm.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = 1669233598L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMember member = new QMember("member1");

    public final DateTimePath<java.time.LocalDateTime> createDt = createDateTime("createDt", java.time.LocalDateTime.class);

    public final StringPath memberEmail = createString("memberEmail");

    public final NumberPath<Long> memberId = createNumber("memberId", Long.class);

    public final EnumPath<com.goorm.profileboxcomm.enumeration.MemberType> memberType = createEnum("memberType", com.goorm.profileboxcomm.enumeration.MemberType.class);

    public final DateTimePath<java.time.LocalDateTime> modifyDt = createDateTime("modifyDt", java.time.LocalDateTime.class);

    public final QProfile profile;

    public final EnumPath<com.goorm.profileboxcomm.enumeration.ProviderType> providerType = createEnum("providerType", com.goorm.profileboxcomm.enumeration.ProviderType.class);

    public QMember(String variable) {
        this(Member.class, forVariable(variable), INITS);
    }

    public QMember(Path<? extends Member> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMember(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMember(PathMetadata metadata, PathInits inits) {
        this(Member.class, metadata, inits);
    }

    public QMember(Class<? extends Member> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.profile = inits.isInitialized("profile") ? new QProfile(forProperty("profile"), inits.get("profile")) : null;
    }

}

