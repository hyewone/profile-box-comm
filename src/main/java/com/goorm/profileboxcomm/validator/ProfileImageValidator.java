package com.goorm.profileboxcomm.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class ProfileImageValidator implements
        ConstraintValidator<ProfileImage, List<MultipartFile>> {

    @Override
    public void initialize(ProfileImage annotation) {
    }

    @Override
    public boolean isValid(List<MultipartFile> imageFiles, ConstraintValidatorContext context) {
//        @Valid @Size(min = 1, max = 5, message = "이미지는 최소1장/최대5장 첨부 가능합니다.")
        if (imageFiles == null || imageFiles.isEmpty() || imageFiles.size() > 5) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("이미지는 최소1장/최대5장 첨부 가능합니다.")
                    .addConstraintViolation();
            return false;
        }

        for (MultipartFile imageFile : imageFiles) {
            if (!isValidImage(imageFile)) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("이미지는 2MB를 초과할 수 없습니다.")
                        .addConstraintViolation();
                return false;
            }
        }
        return true;
    }

    private boolean isValidImage(MultipartFile imageFile) {
        long fileSizeInBytes = imageFile.getSize();

        long fileSizeInMB = fileSizeInBytes / (1024 * 1024); // 1MB = 1024KB, 1KB = 1024 bytes

        if (fileSizeInMB > 2) {
            return false;
        }
        return true;
    }
}