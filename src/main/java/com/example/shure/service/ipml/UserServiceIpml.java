package com.example.shure.service.ipml;

import com.example.shure.model.User;
import com.example.shure.repository.UserRepository;
import com.example.shure.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceIpml implements UserService {

    private final UserRepository userRepository;

    public UserServiceIpml(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User updateUser(Long id, User user) {
        User existing = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        existing.setEmail(user.getEmail());
        existing.setPassword(user.getPassword());
        existing.setName(user.getName());
        existing.setPhone(user.getPhone());
        existing.setRole(user.getRole());

        return userRepository.save(existing);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
