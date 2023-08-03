package com.example.company_management.service.impl;

import com.example.company_management.dto.UserDto;
import com.example.company_management.entity.User;
import com.example.company_management.map.UserMap;
import com.example.company_management.repository.UserRepository;
import com.example.company_management.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final UserMap map;

    @Override
    public List<UserDto> findAll(){
        return repository.findAll().stream()
                .map(map::toDto)
                .toList();
    }
    @Override
    public UserDto findById(Long id){
       User search= repository
               .findById(id).orElseThrow();
       return map.toDto(search);
    }
    @Override
    @Transactional(rollbackFor = SQLException.class)
    public void save(UserDto userDto){
         User user=map.toEntity(userDto);
        try {
            repository.save(user);
        }catch (RuntimeException exception){
            throw new RuntimeException("Save zamani xeta bash verdi");
        }
    }

    @Override
    @Transactional()
    public void update(Long id, UserDto userDto) {
        User user=repository.findById(id).orElseThrow();
        user.setFirst_name(userDto.getFirst_name());
        user.setLast_name(userDto.getLast_name());
        user.setBirthdate(userDto.getBirthdate());
        user.setEmail(userDto.getEmail());

        try{
            repository.save(user);
        }catch (RuntimeException ex){
            throw new RuntimeException("Xeta bas verdi");
        }

    }

    @Override
    @Transactional(rollbackFor = SQLException.class)
    public void delete(Long id) {
        if (repository.existsById(id)) {
            try {
                repository.deleteById(id);

            } catch (RuntimeException ex) {
                throw new RuntimeException("Delete zamani xeta bas verdi");
            }
        }
    }
}
