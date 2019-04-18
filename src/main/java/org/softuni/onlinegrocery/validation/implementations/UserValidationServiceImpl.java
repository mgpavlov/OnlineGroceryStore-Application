package org.softuni.onlinegrocery.validation.implementations;

import org.softuni.onlinegrocery.domain.models.service.UserServiceModel;
import org.softuni.onlinegrocery.validation.UserValidationService;
import org.springframework.stereotype.Component;

@Component
public class UserValidationServiceImpl implements UserValidationService {
    @Override
    public boolean isValid(UserServiceModel user) {
        return user != null;
    }
}
