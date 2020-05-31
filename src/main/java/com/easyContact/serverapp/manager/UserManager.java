package com.easyContact.serverapp.manager;

import com.easyContact.serverapp.dao.entity.User;
import com.easyContact.serverapp.dao.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserManager {

    private UserRepo userRepo;

    @Autowired
    public UserManager(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public Optional<User> find(Long id) {
        return userRepo.findById(id);
    }

    public Iterable<User> findAll() {
        return userRepo.findAll();
    }

    public User save(User data) {
        return userRepo.save(data);
    }

    public void deleteById(Long id) {
        userRepo.deleteById(id);
    }

    public Long getIdByEmail(String email) {
        return userRepo.findFirstByEmail(email).getId();
    }
}
