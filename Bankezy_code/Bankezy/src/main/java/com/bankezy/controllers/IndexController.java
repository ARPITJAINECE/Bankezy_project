package com.bankezy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    @GetMapping("/")
    public ModelAndView getIndex() {
        ModelAndView getIndexPage = new ModelAndView("index");
        getIndexPage.addObject("PageTitle", "Home");
        System.out.println("in index controller");
        return getIndexPage;
    }
//    @GetMapping("/login")
//    public ModelAndView getLogin() {
//        ModelAndView getLoginPage = new ModelAndView("login");
//        System.out.println("in login controller");
//        getLoginPage.addObject("PageTitle", "Login");
//        return getLoginPage;
//    }

    @GetMapping("/error")
    public ModelAndView getError() {
        ModelAndView getErrorPage = new ModelAndView("error");
        System.out.println("in error controller");
        getErrorPage.addObject("PageTitle", "Errors");
        return getErrorPage;
    }
    @GetMapping("/verify")
    public ModelAndView getVerify() {
        ModelAndView getVerifyPage = new ModelAndView("login");
        System.out.println("in get mapping verify page");
        getVerifyPage.addObject("PageTitle", "Errors");
        return getVerifyPage;
    }
}
