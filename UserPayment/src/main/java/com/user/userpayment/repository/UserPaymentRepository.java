package com.user.userpayment.repository;

import com.user.userpayment.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPaymentRepository extends JpaRepository<Account, Long> {

    void deleteByUserID(Long userID);

}
