package com.goorm.profileboxcomm.validator;

import com.goorm.profileboxcomm.exception.ExceptionEnum;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EnumPatternValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EnumPattern {
    String regexp();
    String message() default "does not match \"{regexp}\"";
    ExceptionEnum enumType();
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}