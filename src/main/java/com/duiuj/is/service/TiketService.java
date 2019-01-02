package com.duiuj.is.service;

import com.duiuj.is.model.TiketModel;

import java.util.List;

public interface TiketService {
    /* CRUD */
    TiketModel add(TiketModel tiketModel);
    TiketModel update(TiketModel tiket);
    void changeStatus(TiketModel tiket);
    void delete(TiketModel tiketModel);

    /* Getter */
    List<TiketModel> getAll();
    TiketModel getById(long id);
    TiketModel getByNamaLengkapAndNomorHandphone(String nama, String noHp);
    TiketModel getByKodeTiket(String kodeTiket);
    int countTicket();
}
