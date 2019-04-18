package org.softuni.onlinegrocery.service;


import org.softuni.onlinegrocery.domain.models.service.UserServiceModel;

import java.util.List;

public interface UserService {

    UserServiceModel register(UserServiceModel userServiceModel);

    List<UserServiceModel> findAllUsers();

    UserServiceModel findByUsername(String username);

    UserServiceModel findById(String id);

    void updateRole(String id, String role);

    UserServiceModel findUserByUserName(String name);
}
