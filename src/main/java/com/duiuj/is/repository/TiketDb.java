package com.duiuj.is.repository;

import com.duiuj.is.model.TiketModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TiketDb extends JpaRepository<TiketModel, Long> {
    TiketModel findByKodeTiket(String kodeTiket);
    TiketModel findByNomorHandphone(String nomorHandphone);
    TiketModel findByNamaLengkapAndNomorHandphone(String namaLengkap, String nomorHandphone);
    TiketModel findById(long id);
}
