package com.android.ecommerce.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DecimalTwoDigitsValidator implements ConstraintValidator<DecimalTwoDigits, Float> {
    @Override
    public void initialize(DecimalTwoDigits annotation) {
    }

    @Override
    public boolean isValid(Float value, ConstraintValidatorContext context) {
        if (value == null) {
            return true; // Laisse la validation de la présence ou non à d'autres contraintes
        }
        return value.toString().matches("^[0-9]+(\\.[0-9]{1,2})?$");
    }

}
