package de.hybris.platform.cuppytrail.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang.StringUtils;


/**
 * @author luca.gennari
 * 
 */
public class NotEmptyCuppyValidator implements ConstraintValidator<NotEmptyCuppy, String>
{
	@Override
	public void initialize(final NotEmptyCuppy constraintAnnotation)
	{
		// empty
	}

	@Override
	public boolean isValid(final String value, final ConstraintValidatorContext context)
	{
		return value != null && !StringUtils.isEmpty(value.trim()) && value.matches(".*[a-zA-Z].*");
	}
}
