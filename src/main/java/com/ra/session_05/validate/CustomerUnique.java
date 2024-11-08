package com.ra.session_05.validate;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CustomerValidate.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomerUnique {
    String message() default "email duplicate entry";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
