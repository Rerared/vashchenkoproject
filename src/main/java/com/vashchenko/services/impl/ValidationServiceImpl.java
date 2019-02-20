package com.vashchenko.services.impl;

import com.vashchenko.exceptions.BusinessException;
import com.vashchenko.services.ValidationService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationServiceImpl implements ValidationService {
    @Override
    public void validateAge(int age) throws BusinessException {
        if (age > 150 || age < 0) {
            throw new BusinessException("Age is not correct");
        }

    }

    @Override
    public void validateEmail(String email) throws BusinessException {
        Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        if(!matcher.find()){
            throw new BusinessException("Email is not correct");
        }
    }

    @Override
    public void validatePhoneNumber(String phoneNumber) throws BusinessException {
        Pattern pattern = Pattern.compile( "(067|097|050)\\d{7}" );
        Matcher matcher = pattern.matcher(phoneNumber);
        if(!matcher.find()){
            throw new BusinessException("Phone number is not correct");
        }
    }
}
