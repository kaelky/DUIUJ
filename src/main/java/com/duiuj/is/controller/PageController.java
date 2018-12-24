package com.duiuj.is.controller;

import com.duiuj.is.repository.UserDb;
import com.duiuj.is.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserDb userDb;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

}
