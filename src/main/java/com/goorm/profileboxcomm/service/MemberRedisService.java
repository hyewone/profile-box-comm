package com.goorm.profileboxcomm.service;

import com.goorm.profileboxcomm.dto.member.MemberDTO;
import com.goorm.profileboxcomm.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberRedisService {

//    private final MemberRedisRepository memberRedisRepository;
    private final RedisTemplate<String, Object> redisTemplate;

    public void saveMemberToRedis(String jwtToken, Member member) {
        String key = "member:" + jwtToken;
        MemberDTO memberDTO = Member.toDTO(member);
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(MemberDTO.class));
        redisTemplate.opsForValue().set(key, memberDTO);
    }

    public Member getMemberFromRedis(String jwtToken) {
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(MemberDTO.class));
        String key = "member:" + jwtToken;
        MemberDTO memberDTO = (MemberDTO) redisTemplate.opsForValue().get(key);
        Member member = MemberDTO.toEntity(memberDTO);
        return member;
    }
}
