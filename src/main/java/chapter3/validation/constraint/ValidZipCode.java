package chapter3.validation.constraint;

import chapter3.validation.implementation.ZipCodeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = ZipCodeValidator.class)
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
public @interface ValidZipCode {
	String message() default "{chapter3.validation.constraint.ValidZipCode.message}";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	
	@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
	@Retention(RUNTIME)
	@interface List {
		ValidZipCode[] value();
	}
}
