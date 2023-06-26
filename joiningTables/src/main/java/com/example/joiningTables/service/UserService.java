package com.example.joiningTables.service;

import com.example.joiningTables.entity.User;
import com.example.joiningTables.exception.DataNotFoundException;
import com.example.joiningTables.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> getSingleUserDetails(int id) {
        Optional<User> user = userRepository.findById(id);
        try {
            if (user.isPresent()) {
                return user;
            }
        } catch (DataNotFoundException dataNotFoundException) {
            throw new DataNotFoundException("no data");
        }

//            return user;
        return user;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User updateUserDetails(int id, User user) {
        User usr = userRepository.findById(user.getId()).orElse(null);
        usr.setId(user.getId());
        usr.setUserName(user.getUserName());
        User updatedUser = userRepository.save(usr);
        return updatedUser;
    }

    public void deleteUser(int id){
        userRepository.deleteById(id);
    }
}
