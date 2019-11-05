package pl.akademiaspring.week7.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import pl.akademiaspring.week7.model.Car;

public class CarValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Car.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Car car = (Car) o;

        ValidationUtils.rejectIfEmpty(errors, "model", "error.model.empty");
    }
}
