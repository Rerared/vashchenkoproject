package com.vashchenko.services;

import com.vashchenko.exceptions.BusinessException;

public interface ValidationService {
    void validateAge(int age) throws BusinessException;

    void validateEmail(String email) throws BusinessException;

    void validatePhoneNumber(String phoneNumber) throws BusinessException;
}
