package com.duiuj.is.repository;

import com.duiuj.is.model.TiketModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TiketDb extends JpaRepository<TiketModel, Long> {

}
