package com.example.Bookify.services;

import com.example.Bookify.models.User;
import com.example.Bookify.models.UserDTO;
import com.example.Bookify.repositories.UserRepository;
import com.example.Bookify.repositories.UsersBooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(long id){
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> updateUser(Long id, UserDTO userDTO){
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            user.setUsername(userDTO.getUsername());
            return Optional.of(userRepository.save(user));
        }
        return Optional.empty();
    }

    public void deleteUser(long id){
        userRepository.deleteById(id);
    }


}
