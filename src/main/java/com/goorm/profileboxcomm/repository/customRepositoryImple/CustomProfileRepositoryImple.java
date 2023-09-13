package com.goorm.profileboxcomm.repository.customRepositoryImple;

import com.goorm.profileboxcomm.dto.profile.request.SelectProfileListRequestDto;
import com.goorm.profileboxcomm.entity.Profile;
import com.goorm.profileboxcomm.entity.QFilmo;
import com.goorm.profileboxcomm.entity.QProfile;
import com.goorm.profileboxcomm.enumeration.FilmoType;
import com.goorm.profileboxcomm.enumeration.YnType;
import com.goorm.profileboxcomm.repository.customRepository.CustomProfileRepository;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import io.lettuce.core.dynamic.annotation.Param;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CustomProfileRepositoryImple implements CustomProfileRepository {
    private final JPAQueryFactory queryFactory;
    private final QProfile qProfile = QProfile.profile;

//    @Override
//    public Page<Profile> findProfiles(Pageable pageable, SelectProfileListRequestDto dto) {
//        return null;
//    }

    //    @Override
    public Page<Profile> findProfiles(@Param("pageable") Pageable pageable, @Param("dto") SelectProfileListRequestDto dto) {
        JPAQuery<Profile> query = queryFactory.selectFrom(qProfile)
                .where(qProfile.ynType.eq(YnType.Y))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize());

        if (!dto.getTitle().isEmpty()){
            query.where(qProfile.title.contains(dto.getTitle()));
        }

        if (!dto.getActorName().isEmpty()){
            query.where(qProfile.actorName.contains(dto.getActorName()));
        }

        if (!dto.getFilmoType().isEmpty() || !dto.getFilmoName().isEmpty()){
            QFilmo qFilmo = QFilmo.filmo;
            query.innerJoin(qProfile.filmoEntities, qFilmo);

            if (!dto.getFilmoType().isEmpty()){
                query.where(qFilmo.filmoType.eq(FilmoType.valueOf(dto.getFilmoType())));
            }
            if (!dto.getFilmoName().isEmpty()){
                query.where(qFilmo.filmoName.contains(dto.getFilmoName()));
            }
        }
        return new PageImpl<>(query.fetch(), pageable, query.fetchCount());
    }
}
