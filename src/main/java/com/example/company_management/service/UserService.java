package com.example.company_management.service;


import com.example.company_management.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> findAll();
    UserDto findById(Long id);
    void save (UserDto userDto);
    void update(Long id,UserDto userDto);
    void delete(Long id);
}
