package com.bankezy.controllers;


import com.bankezy.helpers.Token;
import com.bankezy.models.Users;
import com.bankezy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public ModelAndView getLogin() {
        System.out.println("In Login Page Controller");
        ModelAndView getLoginPage = new ModelAndView("login");
        // Set Token String:
        String token = Token.generateToken();
        // Send Token to View:
        getLoginPage.addObject("token", token);
        getLoginPage.addObject("PageTitle", "Login");
        return getLoginPage;
    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password,
                        @RequestParam("_token") String token,
                        Model model,
                        HttpSession session) {

        // TODO: VALIDATE INPUT FIELDS / FORM DATA:
        if (email.isEmpty() || email == null || password.isEmpty() || password == null) {
            model.addAttribute("error", "Username or Password Cannot be Empty");
            return "login";
        }

        // TODO: CHECK IF EMAIL EXISTS:
        String getEmailInDatabase = userRepository.getUserEmail(email);

        // Check If Email Exists:
        if (getEmailInDatabase != null) {
            // Get Password In Database:
            String getPasswordInDatabase = userRepository.getUserPassword(getEmailInDatabase);
            //System.out.println("before chkpwd");
            // Validate Password:
            if (!BCrypt.checkpw(password, getPasswordInDatabase)) {
                //System.out.println("before chkpwd------");
                model.addAttribute("error", "Incorrect Username or Password");
                System.out.println("after chkpwd");
                return "login";
            }
            //uncomment the below else block if the user account is not verified use it if it is not connected to email but database is working fine
            // TODO : CHECK IF USER ACCOUNT IS VERIFIED:
//            else {
//                model.addAttribute("success", "login successfull!!!");
//                return "login";
//            }

            // End Of Validate Password.
        }
        else {
            model.addAttribute("error", "Something went wrong please contact support");
            return "error";
        }
        // Check If Email Exists.

        // TODO : CHECK IF USER ACCOUNT IS VERIFIED:
       int verified = userRepository.isVerified(getEmailInDatabase);

        // Check If Account is verified:
//        if (verified != 1){     //use this if statement if account is successfully verified through email
        if (verified != 0){
            String msg = "This Account is not yet Verified, please check email and verify account";
            model.addAttribute("error", msg);
            return "login";
        }
        // End Of Check If Account is verified.

        // TODO: PROCEED TO LOG THE USER IN:
        Users user = userRepository.getUserDetails(getEmailInDatabase);

        // Set Session Attributes:
        session.setAttribute("user", user);
        session.setAttribute("token", token);
        session.setAttribute("authenticated", true);

        return "redirect:/app/dashboard";

    }
        // End Of Authentication Method.

    @GetMapping("/logout")
    public String logout(HttpSession session, RedirectAttributes redirectAttributes){
        session.invalidate();
        System.out.println("in auth controller-->get mapping --> after invalidate --> for logout");
        redirectAttributes.addFlashAttribute("logged_out", "Logged out successfully");
        System.out.println("logged out successfully from auth controller's logout ger mapping");
        return "redirect:/login";
    }

    }
