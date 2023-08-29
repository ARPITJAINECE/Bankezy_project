package com.bankezy.controllers;

import com.bankezy.models.Account;
import com.bankezy.models.PaymentHistory;
import com.bankezy.models.TransactionHistory;
import com.bankezy.models.Users;
import com.bankezy.repository.AccountRepository;
import com.bankezy.repository.PaymentHistoryRepository;
import com.bankezy.repository.TransactHistoryRepository;
import com.bankezy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/app")
public class AppController {
@Autowired
private UserRepository userRepository;
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PaymentHistoryRepository paymentHistoryRepository;

    @Autowired
    private TransactHistoryRepository transactHistoryRepository;

    Users user;

    @GetMapping("/dashboard")
    public ModelAndView getDashboard(HttpSession session){
        System.out.println("in app-dashboard of get mapping");
        ModelAndView getDashboardPage = new ModelAndView("dashboard");

        // Get the details of the logged i user:
        user = (Users)session.getAttribute("user");

        // Get The Accounts Of The Logged In User:
        List<Account> getUserAccounts = accountRepository.getUserAccountsById(user.getUser_id());

        // Get Balance:
        BigDecimal totalAccountsBalance = accountRepository.getTotalBalance(user.getUser_id());

        // Set Objects:
        getDashboardPage.addObject("userAccounts", getUserAccounts);
        getDashboardPage.addObject("totalBalance", totalAccountsBalance);

        return getDashboardPage;
    }

    @GetMapping("/payment_history")
    public ModelAndView getPaymentHistory(HttpSession session){
        // Set View:
        ModelAndView getPaymentHistoryPage = new ModelAndView("paymentHistory");

        // Get Logged In User:\
        user = (Users) session.getAttribute("user");

        // Get Payment History / Records:
        List<PaymentHistory> userPaymentHistory = paymentHistoryRepository.getPaymentRecordsById(user.getUser_id());

        getPaymentHistoryPage.addObject("payment_history", userPaymentHistory);

        return getPaymentHistoryPage;

    }


    @GetMapping("/transact_history")
    public ModelAndView getTransactHistory(HttpSession session){
        // Set View:
        ModelAndView getTransactHistoryPage = new ModelAndView("transactHistory");

        // Get Logged In User:\
        user = (Users) session.getAttribute("user");

        // Get Payment History / Records:
        List<TransactionHistory> userTransactHistory = transactHistoryRepository.getTransactionRecordsById(user.getUser_id());

        getTransactHistoryPage.addObject("transact_history", userTransactHistory);

        return getTransactHistoryPage;

    }

    @GetMapping("/user_details")
    public ModelAndView getUserDetails(HttpSession session){
        // Set View:
        ModelAndView getUserDetailsPage = new ModelAndView("user-details");

        // Get Logged In User:\
        user = (Users) session.getAttribute("users");

        // Get Payment History / Records:
        List<Users> userDetails = userRepository.getUserDetails();

        getUserDetailsPage.addObject("user_details",userDetails);
        System.out.println("before return in app controllers get mapping of user-list");
        return getUserDetailsPage;

    }



}
