package com.duiuj.is.controller;

import com.duiuj.is.model.TiketModel;
import com.duiuj.is.service.TiketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Controller
public class TiketController {
    @Autowired
    private TiketService tiketService;

    @GetMapping (value = "/ticket/check/kode")
    private String checkTicketStatusWithTicket(@RequestParam("kodeTiket") String kodeTiket, Model model) {
        TiketModel ticket = tiketService.getByKodeTiket(kodeTiket);
        model.addAttribute("ticket", ticket);
        return "tiket-detail";
    }
    
    @PostMapping(value="/main-event/ticket/order")
    public String addTiket(@ModelAttribute TiketModel ticket, Model model){
        boolean flag = true;
        while(flag){
            String uuid = UUID.randomUUID().toString().substring(0,6).toUpperCase();
            for(TiketModel oldTiket: tiketService.getAll()){
                if(uuid.equals(oldTiket.getKodeTiket())){
                    flag = true;
                }
                else{
                    flag = false;
                    ticket.setKodeTiket(uuid);
                }
            }
        }

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        ticket.setDate(dtf.format(now));

        tiketService.add(ticket);
        model.addAttribute("ticket", ticket);
        return "order_success";
    }
    
    @PutMapping(value = "/main-event/pay")
    public TiketModel updateTiketSubmit(@RequestParam(value = "ticket-id") long id,
                                    @RequestBody TiketModel tiket) {
        TiketModel oldTiket = tiketService.getById(id);
        if (oldTiket.equals(null)) {
//            return "Couldn't find your tiket";
        }
        return tiketService.update(tiket);
    }

    @GetMapping(value = "/main-event/pay/ticket-status")
    public TiketModel viewTiketWithId(@RequestParam(value = "ticket-id") long id){
        TiketModel tiket = tiketService.getById(id);
        return tiket;
    }

    @GetMapping(value = "/main-event/pay/ticket")
    public TiketModel viewTiketWithId(@RequestParam(value = "nama-lengkap") String nama,
                                      @RequestParam(value = "nomor-hp") String noHp){
        TiketModel tiket = tiketService.getByNamaLengkapAndNomorHandphone(nama, noHp);
        return tiket;
    }

    @GetMapping(value = "/main-event/ticket/ubah/{IDTicket}")
    public String updateTicketData(@PathVariable (value = "IDTicket") long idTicket, Model model) throws IOException {
        TiketModel ticket = tiketService.getById(idTicket);
        model.addAttribute("ticket", ticket);
        return "update-ticket";
    }

    @PostMapping(value = "/main-event/ticket/ubah")
    public String updateTicketData(@ModelAttribute TiketModel ticket, Model model){
        tiketService.update(ticket);
        model.addAttribute("ticket", ticket);
        return "tiket-detail";
    }

    @GetMapping(value = "/main-event/info-pembayaran")
    public String infoPembayaran(){
        return "info-pembayaran";
    }
}
