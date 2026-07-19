package com.user.userinfo.repository;

import com.user.userinfo.entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import jakarta.persistence.LockModeType;
import java.util.Optional;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {

    // Pessimistic lock to prevent race conditions during debit/transfer
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT b FROM BankAccount b WHERE b.id = :id")
    Optional<BankAccount> findByIdForUpdate(Long id);
}
