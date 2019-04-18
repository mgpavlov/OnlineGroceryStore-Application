package org.softuni.onlinegrocery.validation;

import org.softuni.onlinegrocery.domain.models.service.UserServiceModel;

public interface UserValidationService {
    boolean isValid(UserServiceModel user);
}
