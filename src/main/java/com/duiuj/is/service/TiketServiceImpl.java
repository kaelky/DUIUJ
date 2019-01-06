package com.duiuj.is.service;

import com.duiuj.is.model.TiketModel;
import com.duiuj.is.repository.TiketDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TiketServiceImpl implements TiketService {
    @Autowired
    private TiketDb tiketDb;

    /* CRUD Tiket */
    @Override
    public TiketModel add(TiketModel tiketModel) {
        return tiketDb.save(tiketModel);
    }

    @Override
    public TiketModel update(TiketModel tiket) {
        TiketModel oldTiket = tiketDb.findById(tiket.getId());
        oldTiket.setNamaLengkap(tiket.getNamaLengkap());
        oldTiket.setNomorHandphone(tiket.getNomorHandphone());
        oldTiket.setAsalSekolah(tiket.getAsalSekolah());
        oldTiket.setPilihanJurusan1(tiket.getPilihanJurusan1());
        oldTiket.setPilihanJurusan2(tiket.getPilihanJurusan2());
        oldTiket.setPilihanJurusan3(tiket.getPilihanJurusan3());
        oldTiket.setStatusPembayaran(tiket.getStatusPembayaran());
        return tiketDb.save(oldTiket);
    }

    @Override
    public void changeStatus(TiketModel tiket) {
        if (tiket.getStatusPembayaran() == 1) {
            tiket.setStatusPembayaran(0);
        } else {
            tiket.setStatusPembayaran(1);
        }
        tiketDb.save(tiket);
    }

    @Override
    public void delete(TiketModel tiketModel) {
        tiketDb.delete(tiketModel);
    }

    /* Getter */

    @Override
    public List<TiketModel> getAll() {
        return tiketDb.findAll();
    }

    @Override
    public TiketModel getById(long id) {
        return tiketDb.findById(id);
    }

    @Override
    public TiketModel getByNamaLengkapAndNomorHandphone(String nama, String noHp) {
        return tiketDb.findByNamaLengkapAndNomorHandphone(nama, noHp);
    }

    @Override
    public TiketModel getByKodeTiket(String kodeTiket) {
        return tiketDb.findByKodeTiket(kodeTiket);
    }

    @Override
    public int countTicket(){
        List<TiketModel> tickets = tiketDb.findAll();
        int result = 0;
        for (int i = 0 ; i < tickets.size() ; i++){
            result += 1;
        }
        return result - 1;
    }

    @Override
    public int countTicketValid(){
        List<TiketModel> tickets = tiketDb.findAll();
        int result = 0;
        for (int i = 0 ; i < tickets.size() ; i++){
            if (tickets.get(i).getStatusPembayaran() == 1){
                result += 1;
            }
        }
        return result;
    }
}
