package com.chatter.controller;

import com.chatter.domain.UserDto;
import com.chatter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/", "/home"})
    public String showHome() {
        return "home";
    }

    /*@RequestMapping("/login")
    public String showLogin() { return "login"; }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String showLogin(UserDto user) {
        return "login";
    }*/
}
