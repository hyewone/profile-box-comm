package com.goorm.profileboxcomm.repository;

import com.goorm.profileboxcomm.entity.Member;
import com.goorm.profileboxcomm.enumeration.ProviderType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface AuthRepository extends JpaRepository<Member, Long>{

    @Override
    public Page<Member> findAll(@Param("pageable") Pageable pageable);

    Optional<Member> findAllByMemberEmailAndProviderType(@Param("memberEmail") String memberEmail, @Param("providerType") ProviderType providerType);
}
