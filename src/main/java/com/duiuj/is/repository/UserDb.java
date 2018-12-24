package com.duiuj.is.repository;

import com.duiuj.is.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDb extends JpaRepository<UserModel, Long> {
    UserModel findByEmail(String email);
}
