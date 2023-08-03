package com.example.company_management.dto;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class PositionDto {
    private String name;
    private Long user_id;
}
