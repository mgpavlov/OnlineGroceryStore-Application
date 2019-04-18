package org.softuni.onlinegrocery.service;

import org.softuni.onlinegrocery.domain.entities.Role;
import org.softuni.onlinegrocery.domain.entities.User;
import org.softuni.onlinegrocery.domain.models.service.UserServiceModel;
import org.softuni.onlinegrocery.repository.ProductRepository;
import org.softuni.onlinegrocery.repository.UserRepository;
import org.softuni.onlinegrocery.repository.UserRoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static org.softuni.onlinegrocery.util.constants.ValidationErrorMessages.*;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           UserRoleRepository userRoleRepository,
                           ProductRepository productRepository, ModelMapper modelMapper,
                           BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails result = this.userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(DEFAULT_USER_NOT_FOUND_EX_MSG));
        return result;
    }

    @Override
    public UserServiceModel register(UserServiceModel userServiceModel) {
        User userEntity = this.modelMapper.map(userServiceModel, User.class);

        String encodedPassword = bCryptPasswordEncoder.encode(userServiceModel.getPassword());
        userEntity.setPassword(encodedPassword);
        userEntity.setAuthorities(getRolesForRegistration());

        return modelMapper.map(this.userRepository.saveAndFlush(userEntity), UserServiceModel.class);
    }

    @Override
    public List<UserServiceModel> findAllUsers() {
        return this.userRepository.findAll()
                .stream()
                .map(uEntity -> this.modelMapper.map(uEntity, UserServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserServiceModel findByUsername(String username) {
        User userEntity = this.userRepository.findByUsername(username).orElse(null);

        return userEntity == null ? null
                : this.modelMapper.map(userEntity, UserServiceModel.class);
    }

    @Override
    public UserServiceModel findById(String id) {
        User userEntity = this.userRepository.findById(id).orElse(null);

        return userEntity == null ? null
                : this.modelMapper.map(userEntity, UserServiceModel.class);
    }

    @Override
    public void updateRole(String id, String role) {
        User userEntity = this.userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException(DEFAULT_USER_NOT_FOUND_EX_MSG));

        boolean isRootAdmin = userEntity.getAuthorities()
                .stream()
                .map(Role::getAuthority)
                .collect(Collectors.toList())
                .contains(ROOT_ADMIN);
        if (isRootAdmin) {
            throw new IllegalArgumentException(DEFAULT_NOT_AUTHORIZE_EX_MSG);
        }

        updateUserRole(userEntity, role);
        this.userRepository.saveAndFlush(userEntity);
    }

    @Override
    public UserServiceModel findUserByUserName(String username) {
        return this.userRepository.findByUsername(username)
                .map(u -> this.modelMapper.map(u, UserServiceModel.class))
                .orElseThrow(() -> new UsernameNotFoundException(DEFAULT_USER_NOT_FOUND_EX_MSG));
    }


    private void updateUserRole(User userEntity, String role) {
        Set<Role> newRole = new HashSet<>();
        switch (role) {
            case ROLE_USER:
                newRole.add(this.userRoleRepository.findByAuthority(ROLE_USER));
                break;
            case ROLE_MODERATOR:
                newRole.add(this.userRoleRepository.findByAuthority(ROLE_MODERATOR));
                newRole.add(this.userRoleRepository.findByAuthority(ROLE_USER));
                break;
            case ROLE_ADMIN:
                newRole.add(this.userRoleRepository.findByAuthority(ROLE_ADMIN));
                newRole.add(this.userRoleRepository.findByAuthority(ROLE_MODERATOR));
                newRole.add(this.userRoleRepository.findByAuthority(ROLE_USER));
                break;
        }
        userEntity.setAuthorities(newRole);
    }

    private Set<Role> getRolesForRegistration() {
        Set<Role> roles = new HashSet<>();

        if(this.userRepository.count() == 0) {
            roles.add(this.userRoleRepository.findByAuthority(ROOT_ADMIN));
            roles.add(this.userRoleRepository.findByAuthority(ROLE_ADMIN));
            roles.add(this.userRoleRepository.findByAuthority(ROLE_ADMIN));
            roles.add(this.userRoleRepository.findByAuthority(ROLE_MODERATOR));
            roles.add(this.userRoleRepository.findByAuthority(ROLE_USER));
        } else {
            roles.add(this.userRoleRepository.findByAuthority(ROLE_USER));
        }

        return roles;
    }
}
