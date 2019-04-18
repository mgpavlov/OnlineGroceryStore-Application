package org.softuni.onlinegrocery.domain.models.view;

import java.util.Set;

public class UsersViewModel {

    private String id;
    private String username;
    private String email;
    private String address;
    private Set<RoleViewModel> authorities;

    public UsersViewModel() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<RoleViewModel> getAuthorities() {
        return this.authorities;
    }

    public void setAuthorities(Set<RoleViewModel> authorities) {
        this.authorities = authorities;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
