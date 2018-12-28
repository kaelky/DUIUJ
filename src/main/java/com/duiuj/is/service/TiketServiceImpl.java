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

    @Override
    public List<TiketModel> findAll() {
        return tiketDb.findAll();
    }

    @Override
    public void deleteTicket(long id){
        tiketDb.deleteById(id);
    }

    @Override
    public TiketModel findById(long id){
        return tiketDb.getOne(id);
    }

    @Override
    public void changeStatusTiket(TiketModel tiket){
        if (tiket.getStatusPembayaran() == 1){
            tiket.setStatusPembayaran(0);
        }
        else {
            tiket.setStatusPembayaran(1);
        }
        tiketDb.save(tiket);
    }
}
