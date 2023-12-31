package com.android.ecommerce.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DecimalTwoDigitsValidator.class)
public @interface DecimalTwoDigits {
    String message() default "Decimal must two number after the dot";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
