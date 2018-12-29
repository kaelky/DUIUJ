package com.duiuj.is.controller;

import com.duiuj.is.model.TiketModel;
import com.duiuj.is.service.TiketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.io.IOException;

@RestController
public class TiketController {
    @Autowired
    private TiketService tiketService;

    @GetMapping (value = "/cek-status-tiket/{IDTiket}")
    private String viewTiketDetail(@PathVariable(value = "IDTiket") long IDTiket, Model model) throws IOException {
        TiketModel ticket = tiketService.getById(IDTiket);
        model.addAttribute("ticket", ticket);
        return "tiket-detail";
    }

    @PostMapping(value="/main-event/pay")
    public TiketModel addTiket(@RequestBody TiketModel tiket){
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
        return tiketService.add(tiket);
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
