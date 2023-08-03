package com.example.company_management.map;

import com.example.company_management.dto.UserDto;
import com.example.company_management.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserMap {
    UserMap MAPPER= Mappers.getMapper(UserMap.class);

    //@Mapping(target = "company", expression = "java(company.getId())")
    UserDto  toDto(User user);

//    @Mapping(target = "id",ignore = true)
//    @Mapping(target = "password",ignore = true)
    //@Mapping(target = "company_id",expression = "java(")
    User toEntity(UserDto userDto);

    default Set<Long> mapUserDtoToIds(Set<User> users) {
        return users.stream()
                .map(User::getId)
                .collect(Collectors.toSet());
    }
    default Long userToLong(User user){
        return user.getId();
    }

    default User toUser(Long user_id){
       User user=new User();
        user.setId(user_id);
        return user;
    }
}
