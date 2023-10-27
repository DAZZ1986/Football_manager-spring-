package com.dfm.DFManager.repository;

import com.dfm.DFManager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

//это некий слой, который будет отвечать за взаимодействие с БД  (SpringData)
public interface UserRepository extends JpaRepository<User, Long> {

}
