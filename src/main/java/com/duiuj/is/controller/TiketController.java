package com.duiuj.is.controller;

import com.duiuj.is.model.TiketModel;
import com.duiuj.is.service.TiketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.UUID;

@Controller
public class TiketController {
    @Autowired
    private TiketService tiketService;

    private RedirectView redirectView;

    @GetMapping (value = "/ticket/check")
    private String checkTicketStatus(){
        return "check-status";
    }

  /*  @PostMapping (value = "/ticket/check")
    private RedirectView checkTicketStatus(@ModelAttribute TicketWithID objekPengecekan) {
        redirectView.setUrl("/ticket/check" + objekPengecekan.getKodeTiket());
        return redirectView;
    }*/

    @GetMapping (value = "/ticket/check/kode")
    private String checkTicketStatusWithTicket(@RequestParam("kodeTiket") String kodeTiket, Model model) {
        TiketModel ticket = tiketService.getByKodeTiket(kodeTiket);
        model.addAttribute("ticket", ticket);
        return "tiket-detail";
    }

    @GetMapping (value = "/ticket/check/pulih")
    private String checkTicketStatusWithNamaLengkapAndNomorHandphone(@RequestParam("namaLengkap") String namaLengkap,
                                                                     @RequestParam("nomorHandphone") String nomorHandphone,
                                                                     Model model) {
        TiketModel ticket = tiketService.getByNamaLengkapAndNomorHandphone(namaLengkap, nomorHandphone);
        model.addAttribute("ticket", ticket);
        return "tiket-detail";
    }
    
    @GetMapping(value = "/main-event/order")
    private String order(Model model){
        TiketModel tiket = new TiketModel();
        model.addAttribute("tiket", tiket);
        return "main-event_order";
    }
    
    @PostMapping(value="/main-event/pay")
    public String addTiket(@ModelAttribute TiketModel tiket, Model model){
        boolean flag = true;
        while(flag){
            String uuid = UUID.randomUUID().toString().substring(0,8).toUpperCase();
            for(TiketModel oldTiket: tiketService.getAll()){
                if(uuid.equals(oldTiket.getKodeTiket())){
                    flag = true;
                }else{
                    flag = false;
                    tiket.setKodeTiket(uuid);
                }
            }
        }
        tiket.setPasswordTiket(tiket.getKodeTiket());
        tiketService.add(tiket);
        model.addAttribute("tiket", tiket);
        return "main-event_pay";
    }

    
    /*@DeleteMapping(value="/admin/tickets/delete/{ticket-id}")
    public void deleteTiket(@PathVariable("ticket-id") long id){
        TiketModel tiket = tiketService.getById(id);
        tiketService.delete(tiket);
    }*/

    /*@GetMapping(value="/admin/tickets/get-all")
    public List<TiketModel> viewAllTickets(){
        return tiketService.getAll();
    }*/
    
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
}
