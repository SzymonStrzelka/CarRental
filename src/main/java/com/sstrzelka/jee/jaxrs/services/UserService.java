package com.sstrzelka.jee.jaxrs.services;

import com.sstrzelka.jee.jaxrs.models.dto.UserDto;
import com.sstrzelka.jee.jaxrs.models.entities.User;
import com.sstrzelka.jee.jaxrs.repositories.UserRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.Collection;

@ApplicationScoped
public class UserService implements Serializable {

    @Inject
    private UserRepository userRepository;

    public Collection<User> getUserList() {
       return userRepository.getUserList();
    }

    public User saveUser(UserDto userDto){
        return userRepository.saveUser(userDto);
    }

    public void removeUser(int id) {
        userRepository.removeUser(id);
    }

    public User updateUser(int id, UserDto userDto) {
        return userRepository.updateUser(id, userDto);
    }

    public User getUser(int id){
        return userRepository.getUser(id);
    }
}
