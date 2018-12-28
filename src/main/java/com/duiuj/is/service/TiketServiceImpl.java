package com.duiuj.is.service;

import com.duiuj.is.model.TiketModel;
import com.duiuj.is.repository.TiketDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TiketServiceImpl implements TiketService{
    @Autowired
    private TiketDb tiketDb;

    @Override
    public TiketModel add(TiketModel tiketModel) {
        return tiketDb.save(tiketModel);
    }

    @Override
    public List<TiketModel> getAll() {
        return tiketDb.findAll();
    }

    @Override
    public TiketModel getTiketById(long id) {
        return tiketDb.findById(id);
    }

    @Override
    public void delete(TiketModel tiketModel) {
        tiketDb.delete(tiketModel);
    }

    @Override
    public TiketModel update(TiketModel tiket) {
        TiketModel oldTiket = tiketDb.findById(tiket.getId());
        oldTiket.setNamaLengkap(tiket.getNamaLengkap());
        oldTiket.setNomorHandphone(tiket.getNomorHandphone());
        oldTiket.setAsalSekolah(tiket.getAsalSekolah());
        oldTiket.setKodeTiket(tiket.getKodeTiket());
        oldTiket.setPasswordTiket(tiket.getPasswordTiket());
        oldTiket.setPilihanJurusan1(tiket.getPilihanJurusan1());
        oldTiket.setPilihanJurusan2(tiket.getPilihanJurusan2());
        oldTiket.setPilihanJurusan3(tiket.getPilihanJurusan3());
        oldTiket.setStatusPembayaran(tiket.getStatusPembayaran());
        return tiketDb.save(oldTiket);
    }

    @Override
    public TiketModel getTiketByNamaLengkapAndNoHp(String nama, String noHp) {
        return tiketDb.findByNamaLengkapAndNomorHandphone(nama, noHp);
    }
}
