package fr.esgi.calendrier.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EsgiEmailValidator implements ConstraintValidator<EsgiEmail, String> {


    @Override
    public void initialize(EsgiEmail constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s != null && s.endsWith("@esgi.fr");
    }
}
