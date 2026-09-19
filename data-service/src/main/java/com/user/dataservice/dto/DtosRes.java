package com.user.dataservice.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DtosRes {
    private Long id;
    private String name;
    private int phone_number;
    private String description;
    private String createdBy;
}
