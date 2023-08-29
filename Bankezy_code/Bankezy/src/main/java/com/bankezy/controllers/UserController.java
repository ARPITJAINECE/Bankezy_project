package com.bankezy.controllers;
import com.bankezy.services.UserService;
//import com.bankezy.mailMessenger.MailMessenger;
import com.bankezy.models.Users;
import com.bankezy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @GetMapping("/employee")
    public String employeePortal() {
        System.out.println("in  UserController employee getMapping");
        return "employee-portal";
    }

    @GetMapping("/employee/user-list")
    public String userList(Model model) {
        List<Users> users = userService.getAllUsers();
        // Replace with your actual method to fetch users

        System.out.println("in  UserController employee/user-list getMapping");
        model.addAttribute("users", users);
        return "user-list";
    }

    @GetMapping("/employee/user-details/{userId}")
    public String userDetails(@PathVariable int userId, Model model) {
        Users user = userService.getUserById(userId); // Replace with your actual method to fetch a user by ID
        model.addAttribute("user", user);
        return "user-details";
    }
    @PostMapping("/employee/delete-user/{userId}")
    public String deleteUser(@PathVariable int userId) {
        userService.deleteUser(userId); // Replace with your actual method to delete a user
        return "redirect:/employee/user-list";
    }
    @GetMapping("/employee/delete-user/{userId}")
    public String deleteConfirmation(@PathVariable int userId, Model model) {
        Users user = userService.getUserById(userId); // Replace with your actual method to fetch a user by ID
        model.addAttribute("user", user);
        return "employee/delete-confirmation";
    }



}



