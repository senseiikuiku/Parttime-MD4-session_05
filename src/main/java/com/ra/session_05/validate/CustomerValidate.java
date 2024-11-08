package com.ra.session_05.validate;

import com.ra.session_05.repository.CustomerRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerValidate implements ConstraintValidator<CustomerUnique,String> {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !customerRepository.existsCustomerByEmail(value);
    }
}