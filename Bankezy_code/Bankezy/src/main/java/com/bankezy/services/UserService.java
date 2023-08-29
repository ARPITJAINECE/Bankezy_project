package com.bankezy.services;

import org.springframework.stereotype.Service;
import com.bankezy.models.Users;
import com.bankezy.repository.UserRepository;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Users> getAllUsers() {
        return (List<Users>) userRepository.findAll();
    }
    public List<Users> getUserDetails(){
        return (List<Users>) userRepository.findAll();
    }

    public Users getUserById(int userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Transactional
    public void deleteUser(int userId) {
        userRepository.deleteById(userId);
    }

    public Users getUserByEmail(String email) {
        return userRepository.getUserDetails(email);
    }

    public String getUserEmail(String email) {
        return userRepository.getUserEmail(email);
    }

    public String getUserPassword(String email) {
        return userRepository.getUserPassword(email);
    }

    public int isVerified(String email) {
        return userRepository.isVerified(email);
    }

    public void registerUser(String first_name, String last_name, String email, String password, String token, int code) {
        userRepository.registerUser(first_name, last_name, email, password, token, code);
    }

    @Transactional
    public void verifyAccount(String token, String code) {
        userRepository.verifyAccount(token, code);
    }

    public String checkToken(String token) {
        return userRepository.checkToken(token);
    }

}
