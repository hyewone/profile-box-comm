package com.goorm.profileboxcomm.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ProfileImageValidator.class)
@Target({ElementType.TYPE_USE, ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ProfileImage {
    String message() default "Invalid image format or size";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
