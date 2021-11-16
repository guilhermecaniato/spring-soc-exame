package br.com.soc.exame.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = DataExameValidacao.class)
public @interface DataExame {
	String message() default "{DataExame.exame.dataExame}";

	Class<?>[] groups() default {};

	public abstract Class<? extends Payload>[] payload() default {};
}
