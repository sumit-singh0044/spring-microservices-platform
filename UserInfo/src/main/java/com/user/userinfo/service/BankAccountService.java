package com.user.userinfo.service;

import com.user.userinfo.entity.BankAccount;
import com.user.userinfo.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class BankAccountService {


    private final BankAccountRepository repository;

    public BankAccountService(BankAccountRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public BankAccount createAccount(String name, BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Initial amount cannot be negative");
        }
        return repository.save(new BankAccount(name, amount));
    }

    public BankAccount getAccount(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Account not found: " + id));
    }

    @Transactional
    public BankAccount debit(Long accountId, BigDecimal amount) {
        validateAmount(amount);

        BankAccount account = repository.findByIdForUpdate(accountId)
                .orElseThrow(() -> new IllegalArgumentException("Account not found: " + accountId));

        if (account.getAmount().compareTo(amount) < 0) {
            throw new IllegalStateException("Insufficient balance in account: " + accountId);
        }

        account.setAmount(account.getAmount().subtract(amount));
        return repository.save(account);
    }

    @Transactional
    public void transfer(Long fromAccountId, Long toAccountId, BigDecimal amount) {
        validateAmount(amount);

        if (fromAccountId.equals(toAccountId)) {
            throw new IllegalArgumentException("Cannot transfer to the same account");
        }

        // Lock accounts in a consistent order (by id) to avoid deadlocks
        Long firstLockId = Math.min(fromAccountId, toAccountId);
        Long secondLockId = Math.max(fromAccountId, toAccountId);

        BankAccount first = repository.findByIdForUpdate(firstLockId)
                .orElseThrow(() -> new IllegalArgumentException("Account not found: " + firstLockId));
        BankAccount second = repository.findByIdForUpdate(secondLockId)
                .orElseThrow(() -> new IllegalArgumentException("Account not found: " + secondLockId));

        BankAccount from = fromAccountId.equals(firstLockId) ? first : second;
        BankAccount to = toAccountId.equals(firstLockId) ? first : second;

        if (from.getAmount().compareTo(amount) < 0) {
            throw new IllegalStateException("Insufficient balance in account: " + fromAccountId);
        }

        from.setAmount(from.getAmount().subtract(amount));
        to.setAmount(to.getAmount().add(amount));

        repository.save(from);
        repository.save(to);
    }

    private void validateAmount(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
    }

}
