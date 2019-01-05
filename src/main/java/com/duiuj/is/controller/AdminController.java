package com.duiuj.is.controller;

import com.duiuj.is.model.TiketModel;
import com.duiuj.is.service.TiketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private TiketService tiketService;

    private RedirectView redirectView = new RedirectView();

    @GetMapping(value = "/admin/tickets/DUIUJ15SEMANGATYAKABCDEF123")
    private String admin(Model model){

        List<TiketModel> tickets = tiketService.getAll();

        Collections.sort(tickets, new Comparator<TiketModel>() {
            @Override
            public int compare(TiketModel o1, TiketModel o2) {
                return (o1.getDate()).compareTo(o2.getDate());
            }
        });

        model.addAttribute("tickets", tickets);

        int totalTicket = tiketService.countTicket();

        model.addAttribute("totalTicket", totalTicket);

        return "admin_tickets";
    }

    @PostMapping(value = "/admin/ticket/changeStatus/{IDTiket}")
    private RedirectView changeStatusTiket(@PathVariable(value = "IDTiket") long idTicket) throws IOException {
        TiketModel ticket = tiketService.getById(idTicket);
        tiketService.changeStatus(ticket);
        redirectView.setUrl("/admin/tickets/DUIUJ15SEMANGATYAKABCDEF123");
        return redirectView;
    }

    @PostMapping (value = "/admin/ticket/delete/{IDTiket}")
    private RedirectView deleteTiket(@PathVariable (value = "IDTiket") long idTicket) throws IOException {
        TiketModel ticket = tiketService.getById(idTicket);
        tiketService.delete(ticket);
        redirectView.setUrl("/admin/tickets/DUIUJ15SEMANGATYAKABCDEF123");
        return redirectView;
    }
}
