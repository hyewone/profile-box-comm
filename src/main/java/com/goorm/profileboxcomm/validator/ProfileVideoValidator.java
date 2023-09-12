package com.goorm.profileboxcomm.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class ProfileVideoValidator implements
        ConstraintValidator<ProfileVideo, List<MultipartFile>> {

    @Override
    public void initialize(ProfileVideo annotation) {
    }

    @Override
    public boolean isValid(List<MultipartFile> videoFiles, ConstraintValidatorContext context) {

//        @Size(max = 2, message = "동영상은 최대2개 첨부 가능합니다.")
        if (videoFiles == null || videoFiles.isEmpty()) {
            return true;
        }

        if (videoFiles.size() > 2) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("동영상은 최대2개 첨부 가능합니다.")
                    .addConstraintViolation();
            return false;
        }

        for (MultipartFile videoFile : videoFiles) {
            if (!isValidVideo(videoFile)) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("동영상은 10MB를 초과할 수 없습니다.")
                        .addConstraintViolation();
                return false;
            }
        }
        return true;
    }

    private boolean isValidVideo(MultipartFile videoFile) {
        long fileSizeInBytes = videoFile.getSize();

        long fileSizeInMB = fileSizeInBytes / (1024 * 1024); // 1MB = 1024KB, 1KB = 1024 bytes

        if (fileSizeInMB > 10) {
            return false;
        }
        return true;
    }
}
