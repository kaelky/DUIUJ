package com.duiuj.is.repository;

import com.duiuj.is.model.TimModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimDb extends JpaRepository<TimModel, Long> {

}
