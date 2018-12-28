package com.duiuj.is.service;

import com.duiuj.is.model.TiketModel;

import java.util.List;

public interface TiketService {
    List<TiketModel> findAll();
    void deleteTicket(long id);
    TiketModel findById(long id);
    void changeStatusTiket(TiketModel tiket);
}
