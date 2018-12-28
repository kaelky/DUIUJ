package com.duiuj.is.controller;

import com.duiuj.is.model.TiketModel;
import com.duiuj.is.service.TiketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
public class PageController {
    @Autowired
    private TiketService tiketService;

    @GetMapping(value = "/")
    private String home(){
        return "home";
    }

    @GetMapping(value = "/main-event/order")
    private String order(Model model){
        //TODO
        return "main-event_order";
    }

    @PostMapping(value = "main-event/order")
    private String order(){
        //TODO
        //redirect ke page "main-event/pay
        return "main-event_pay";
    }

    @GetMapping(value = "/admin")
    private String admin(Model model){

        List<TiketModel> tickets = tiketService.findAll();

        Collections.sort(tickets, new Comparator<TiketModel>() {
            @Override
            public int compare(TiketModel o1, TiketModel o2) {
                return (o1.getId()+"").compareTo(o2.getId()+"");
            }
        });

        model.addAttribute("tickets", tickets);

        return "admin";
    }
}
