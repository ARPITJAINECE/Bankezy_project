package com.bankezy.controller_advisor;

import com.bankezy.models.Users;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
@ControllerAdvice
public class AdvisorController {
    @ModelAttribute("registerUser")
    public Users getUserDefaults() {
        return new Users();
    }
}
