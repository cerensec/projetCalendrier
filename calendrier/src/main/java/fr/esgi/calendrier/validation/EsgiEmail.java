package fr.esgi.calendrier.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EsgiEmailValidator.class)
@Documented
public @interface EsgiEmail {

    String message() default "Email invalide, il doit être enregistré dans le domaine esgi.fr";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
