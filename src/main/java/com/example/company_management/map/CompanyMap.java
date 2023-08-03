package com.example.company_management.map;

import com.example.company_management.dto.CompanyDto;
import com.example.company_management.dto.UserDto;
import com.example.company_management.entity.Company;
import com.example.company_management.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface CompanyMap {
    CompanyMap MAPPERl= Mappers.getMapper(CompanyMap.class);
    //@Mapping(target = "company", expression = "java(company.getId())")
    CompanyDto toDto(Company company);


    //@Mapping(target = "company_id",expression = "java(")
    Company toEntity(CompanyDto companyDto);

    default Set<Long> mapCompanyDtoToIds(Set<Company> companies) {
        return companies.stream()
                .map(Company::getId)
                .collect(Collectors.toSet());
    }
    default Long companyToLong(Company company){
        return company.getId();
    }

    default Company toCompany(Long company_id){
        Company company=new Company();
        company.setId(company_id);
        return company;
    }
}
