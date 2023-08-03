package com.example.company_management.dto;

import com.example.company_management.entity.User;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class CompanyDto {
    private String name;
    private LocalDate create_date;
    private Long user_id;
}
