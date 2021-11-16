package br.com.soc.exame.validation;

import java.time.LocalDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DataExameValidacao implements ConstraintValidator<DataExame, LocalDate> {

	@Override
	public boolean isValid(LocalDate localDate, ConstraintValidatorContext context) {

		if (localDate == null) {
			return true;
		}

		return LocalDate.now().compareTo(localDate) <= 0;
	}
}
