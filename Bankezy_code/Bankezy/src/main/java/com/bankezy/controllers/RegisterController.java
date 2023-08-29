package com.bankezy.controllers;

import com.bankezy.helpers.HTML;
import com.bankezy.helpers.Token;
import com.bankezy.mailMessenger.MailMessenger;
import com.bankezy.mailMessenger.MailMessenger;
import com.bankezy.models.Users;
import com.bankezy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.util.Random;

@Controller
public class RegisterController {
    @Autowired
    private UserRepository userRepository;


    @GetMapping("/register")
    public ModelAndView getRegister() {
        ModelAndView getRegisterPage = new ModelAndView("register");
        System.out.println("in register controller");
        getRegisterPage.addObject("PageTitle", "Register");
        return getRegisterPage;
    }

    @PostMapping("/register")
    public ModelAndView register(@Valid @ModelAttribute("registerUser") Users user,
                                 BindingResult result,
                                 @RequestParam("first_name") String first_name,
                                 @RequestParam("last_name") String last_name,
                                 @RequestParam("email") String email,
                                 @RequestParam("password") String password,
                                 @RequestParam("confirm_password") String confirm_password) throws MessagingException {
        ModelAndView registrationPage = new ModelAndView("register");
        //check for errors
        if (result.hasErrors() && confirm_password.isEmpty()) {
            registrationPage.addObject("confirm_pass", "The confirm field is required");
            return registrationPage;
        }
        // Check For Errors:
        if(result.hasErrors() && confirm_password.isEmpty()){
            registrationPage.addObject("confirm_pass", "The confirm Field is required");
            return registrationPage;
        }
        // TODO: CHECK FOR PASSWORD MATCH:
        if(!password.equals(confirm_password)){
            registrationPage.addObject("passwordMisMatch", "passwords do not match");
            return registrationPage;
        }

        // TODO: GET TOKEN STRING:
        String token = Token.generateToken();

        // TODO: GENERATE RANDOM CODE:
        Random rand = new Random();
        int bound = 123;
        int code = bound * rand.nextInt(bound);

        // TODO: GET EMAIL HTML BODY:
        String emailBody = HTML.htmlEmailTemplate(token, Integer.toString(code));

        // TODO: HASH PASSWORD:
        String hashed_password = BCrypt.hashpw(password, BCrypt.gensalt());

        // TODO: REGISTER USER:
        userRepository.registerUser(first_name, last_name, email, hashed_password, token, code);

        // TODO: SEND EMAIL NOTIFICATION:
        MailMessenger.htmlEmailMessenger("psaurabhp877@gmail.com", email, "Verify Account", emailBody);

        // TODO: RETURN TO REGISTER PAGE:
        String successMessage = "Account Registered Successfully, Please Check your Email and Verify Account!";
        registrationPage.addObject("success", successMessage);


        return registrationPage;

    }

}

//package com.bankezy.controllers;
//
//import com.bankezy.helpers.HTML;
//import com.bankezy.helpers.Token;
//import com.bankezy.mailMessenger.MailMessenger;
//import com.bankezy.models.User;
//import com.bankezy.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.mail.MessagingException;
//import javax.validation.Valid;
//import java.util.Random;
//
//@Controller
//public class RegisterController {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;
//
//    @GetMapping("/register")
//    public ModelAndView getRegister() {
//        ModelAndView getRegisterPage = new ModelAndView("register");
//        getRegisterPage.addObject("PageTitle", "Register");
//        return getRegisterPage;
//    }
//
//    @PostMapping("/register")
//    public ModelAndView register(@Valid @ModelAttribute("registerUser") User user,
//                                 BindingResult result,
//                                 @RequestParam("password") String password,
//                                 @RequestParam("confirm_password") String confirmPassword) {
//        ModelAndView registrationPage = new ModelAndView("register");
//
//        // Check for validation errors
//        if (result.hasErrors()) {
//            registrationPage.addObject("confirm_pass", "The confirm field is required");
//            return registrationPage;
//        }
//
//        // Check for password match
//        if (!password.equals(confirmPassword)) {
//            registrationPage.addObject("passwordMisMatch", "Passwords do not match");
//            return registrationPage;
//        }
//
//        // Generate token and code
//        String token = Token.generateToken();
//        Random rand = new Random();
//        int code = rand.nextInt(1000); // Adjust this as needed
//
//        // Generate hashed password
//        String hashedPassword = passwordEncoder.encode(password);
//
//        // Register user
//        userRepository.registerUser(user.getFirst_name(), user.getLast_name(), user.getEmail(), hashedPassword, token, code);
//
//        // Generate email body
//        String emailBody = HTML.htmlEmailTemplate(token, Integer.toString(code));
//
//        try {
//            MailMessenger.htmlEmailMessenger("psaurabhp877@gmail.com", user.getEmail(), "Verify Account", emailBody);
//            // Success message
//            String successMessage = "Account Registered Successfully, Please Check your Email and Verify Account!";
//            registrationPage.addObject("success", successMessage);
//        } catch (MessagingException e) {
//            // Handle email sending error
//            // Log the error and provide user-friendly feedback
//            registrationPage.addObject("emailError", "Error sending email. Please try again later.");
//        }
//
//        return registrationPage;
//    }
//
//}
