package com.duiuj.is.controller;

import com.duiuj.is.model.TiketModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("/")
    private String home() {
        return "home";
    }

    @GetMapping("/admin")
    private String adminLogin() {
        return "login";
    }
    
    /**
    @GetMapping(value = "/main-event/order")
    private String order(Model model){
        
        return "main-event_order";
    }

    @PostMapping(value = "main-event/order")
    private String order(){
        //TODO
        //redirect ke page "main-event/pay
        return "main-event_pay";
    }
    **/

    @GetMapping(value = "/main-event")
    private String order(Model model){
        TiketModel newTicket = new TiketModel();
        model.addAttribute("ticket", newTicket);
        return "main-event";
    }

    @GetMapping(value = "/competition")
    private String competition(){
        return "competition";
    }


}
