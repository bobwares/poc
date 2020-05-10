package com.bobwares.poc.test;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

public class ConstraintViolationTester {

  public static <T> Set<ConstraintViolation<T>> getConstraintViolations(T testObject) {
    Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
    return validator.validate(testObject);
  }


}
