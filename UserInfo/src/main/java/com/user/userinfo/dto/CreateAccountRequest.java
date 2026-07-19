package com.user.userinfo.dto;

import java.math.BigDecimal;

public record CreateAccountRequest ( String name,
                                    BigDecimal amount) {

}
