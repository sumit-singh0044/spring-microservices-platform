package com.user.userinfo.dto;

import com.user.userinfo.entity.BankAccount;

import java.math.BigDecimal;

public record BankAccountResponse(
        Long id,
        String name,
        BigDecimal amount
) {
    public static BankAccountResponse fromEntity(BankAccount account) {
        return new BankAccountResponse(
                account.getId(),
                account.getName(),
                account.getAmount()
        );
    }
}