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

@Controller
public class TiketController {
    @Autowired
    private TiketService tiketService;

    private RedirectView redirectView = new RedirectView();

    @GetMapping (value = "/cek-status-tiket/{IDTiket}")
    private String viewTiketDetail(@PathVariable(value = "IDTiket") long IDTiket, Model model) throws IOException {
        TiketModel ticket = tiketService.findById(IDTiket);
        model.addAttribute("ticket", ticket);
        return "tiket-detail";
    }

    @PostMapping (value = "/admin/tiket/changeStatus/{IDTiket}")
    private RedirectView changeStatusTiket(@PathVariable(value = "IDTiket") long id) throws IOException {
        TiketModel tiket = tiketService.findById(id);
        tiketService.changeStatusTiket(tiket);
        redirectView.setUrl("/admin");
        return redirectView;
    }

    @PostMapping (value = "/admin/tiket/delete/{IDTiket}")
    private RedirectView deleteTiket(@PathVariable (value = "IDTiket") long IDTiket) throws IOException {
        tiketService.deleteTicket(IDTiket);
        redirectView.setUrl("/admin");
        return redirectView;
    }
}
