package com.goorm.profileboxcomm.utils;

import com.goorm.profileboxcomm.exception.ApiException;
import com.goorm.profileboxcomm.exception.ExceptionEnum;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Component
public class Utils {

    public static String dateToString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

    public static Date stringToDate(String date) {
        try{
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        }catch (Exception e){
            throw new ApiException(ExceptionEnum.INVALID_DATE_FORMAT);
        }
    }

    public static Timestamp locaclDateToTimestamp(LocalDateTime date) {
        return Timestamp.valueOf(date);
    }

    public static String localDateToString(LocalDateTime date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return date.format(formatter);
    }

    public static LocalDateTime stringToLocalDateTime(String date){
        // 2023-06-28 00:57:48.235
        // yyyy-MM-dd HH:mm:ss.SSS
        // yyyy: 4자리 연도
        // MM: 2자리 월 (01부터 12까지)
        // dd: 2자리 일 (01부터 31까지)
        // HH: 2자리 시간 (00부터 23까지, 24시간 형식)
        // mm: 2자리 분 (00부터 59까지)
        // ss: 2자리 초 (00부터 59까지)
        // SSS: 3자리 밀리초 (000부터 999까지)

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        return LocalDateTime.parse(date, formatter);
    }

    public static Sort.Direction getSrotDirection(String strDirection){
        Sort.Direction sortDirection = null;
        switch (strDirection) {
            case "ASC":
                sortDirection = Sort.Direction.ASC;
                break;
            case "DESC":
                sortDirection = Sort.Direction.DESC;
                break;
            default:
                sortDirection = Sort.Direction.DESC;
                break;
        }
        return sortDirection;
    }

    public static boolean isAdmin(Authentication authentication){
        return authentication.getAuthorities().stream().anyMatch(authority -> authority.getAuthority().equals("ADMIN"));
    }
}
