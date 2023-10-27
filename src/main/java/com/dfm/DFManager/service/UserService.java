package com.dfm.DFManager.service;

import com.dfm.DFManager.model.User;
import com.dfm.DFManager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service    //эта аннотация говорит, что данный класс является компонентом спринга.
public class UserService {
    @Autowired
    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User findById(Long id) {
        return userRepository.getOne(id);
    }
    public List<User> findAll() {
        return userRepository.findAll();
    }
    public User saveUser(User user) {
        return userRepository.save(user);
    }
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
