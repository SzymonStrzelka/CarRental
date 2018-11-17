package com.sstrzelka.jee.jaxrs.repositories;

import com.sstrzelka.jee.jaxrs.models.dto.UserDto;
import com.sstrzelka.jee.jaxrs.models.entities.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collection;

@ApplicationScoped
public class UserRepository {

    @Inject
    private InMemoryRepository repository;

    public Collection<User> getUserList() {
        return repository.getUserList();
    }

    public User saveUser(UserDto userDto) {
        return repository.saveUser(userDto);
    }

    public void removeUser(int id) {
        repository.removeUser(id);
    }

    public User updateUser(int id, UserDto userDto) {
        return repository.updateUser(id, userDto);
    }

    public User getUser(int id) {
        return repository.getUser(id);
    }
}
