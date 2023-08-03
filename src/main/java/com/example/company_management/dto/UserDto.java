package com.example.company_management.dto;

import com.example.company_management.entity.Company;
import com.example.company_management.entity.Position;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class UserDto {

    private String first_name;
    private String last_name;
    private String password;
    private Date birthdate;
    private String email;
    private Long company_id;
    private Long position_id;


}
