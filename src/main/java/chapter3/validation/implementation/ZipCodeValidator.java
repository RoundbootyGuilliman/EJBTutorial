package chapter3.validation.implementation;

import chapter3.validation.constraint.ValidZipCode;
import chapter3.validation.qualifier.USA;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ZipCodeValidator implements ConstraintValidator<ValidZipCode, String> {
	
	@Inject @USA
	private ZipCodeChecker checker;
	private Pattern zipPattern = Pattern.compile("\\d{5}(-\\d{5})?");
	
	@Override
	public void initialize(ValidZipCode constraintAnnotation) {
	
	}
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
		
		if (value == null) {
			return true;
		}
		Matcher matcher = zipPattern.matcher(value);
		if (!matcher.matches()) {
			return false;
		}
		return checker.isZipCodeValid(value);
	}
}
