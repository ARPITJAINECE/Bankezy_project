package com.bankezy.controllers;

import com.bankezy.helpers.GenAccountNumber;
import com.bankezy.models.Users;
import com.bankezy.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @PostMapping("/create_account")
    public String createAccount(@RequestParam("account_name")String accountName,
                                @RequestParam("account_type")String accountType,
                                RedirectAttributes redirectAttributes,
                                HttpSession session){

        // TODO: CHECK FOR EMPTY STRINGS:
        if(accountName.isEmpty() || accountType.isEmpty()){
            redirectAttributes.addFlashAttribute("error", "Account Name and Type Cannot be Empty!");
            //here app/dashboard is for error window
            return "redirect:/app/dashboard";
        }

        // TODO: GET LOGGED IN USER:
        Users user = (Users)session.getAttribute("user");

        // TODO: GET / GENERATE ACCOUNT NUMBER:
        int setAccountNumber = GenAccountNumber.generateAccountNumber();
        String bankAccountNumber = Integer.toString(setAccountNumber);

        // TODO: CREATE ACCOUNT:
        accountRepository.createBankAccount(user.getUser_id(), bankAccountNumber, accountName, accountType );

        // Set Success message:
        redirectAttributes.addFlashAttribute("success", "Account Created Successfully!");
        return "redirect:/app/dashboard";

    }
}
