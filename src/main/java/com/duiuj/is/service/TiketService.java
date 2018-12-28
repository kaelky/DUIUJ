package com.duiuj.is.service;

import com.duiuj.is.model.TiketModel;

import java.util.List;

public interface TiketService {
    TiketModel add(TiketModel tiketModel);
    List<TiketModel> getAll();
    TiketModel getTiketById(long id);
    void delete(TiketModel tiketModel);
    TiketModel update(TiketModel tiket);
    TiketModel getTiketByNamaLengkapAndNoHp(String nama, String noHp);
}
