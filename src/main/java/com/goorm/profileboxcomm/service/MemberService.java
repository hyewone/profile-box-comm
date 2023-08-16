//package com.goorm.profileboxcomm.service;
//
//import com.goorm.profileboxcomm.entity.Member;
//import com.goorm.profileboxcomm.response.ApiResult;
//import lombok.RequiredArgsConstructor;
//import org.springframework.core.ParameterizedTypeReference;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.util.UriComponentsBuilder;
//
//import java.net.URI;
//import java.util.concurrent.ExecutionException;
//
//@Service
//@RequiredArgsConstructor
//public class MemberService {
//    private final RestTemplate restTemplate;
//
//    // admin api로 요청해야함
//    public Member findLoginMemberByEmail(String email, String clientJwtToken) throws ExecutionException, InterruptedException {
////        String serviceName = "<your-service-name>";  // 쿠버네티스 서비스의 이름
////        String serviceUrl = "http://" + serviceName + "/api/v1/crud-api/{email}";  // 서비스의 DNS 이름을 포함한 URL
//
//        String url = "http://localhost:7002";
//        HttpHeaders headers = new HttpHeaders();
//        headers.set(HttpHeaders.AUTHORIZATION, "Bearer " + clientJwtToken);
//
//        HttpEntity<?> requestEntity = new HttpEntity<>(headers);
//
//        URI uri = UriComponentsBuilder
//                .fromUriString(url)
//                .path("/v1/auth/member/{email}")
//                .encode()
//                .build()
//                .expand(email)
//                .toUri();
//
//        ResponseEntity<ApiResult<Member>> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, new ParameterizedTypeReference<ApiResult<Member>>() {});
//        return responseEntity.getBody().getData();
//    }
//}
