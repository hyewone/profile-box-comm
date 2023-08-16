package com.goorm.profileboxcomm.repository;

import com.goorm.profileboxcomm.entity.Member;
import org.springframework.data.repository.CrudRepository;



public interface MemberRedisRepository extends CrudRepository<Member, Long> {
}
