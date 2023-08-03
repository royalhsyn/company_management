package com.example.company_management.service;

import com.example.company_management.dto.CompanyDto;


import java.util.List;


public interface CompanyService {
    List<CompanyDto> findAll();
    CompanyDto findById(Long id);
    void save (CompanyDto companyDto);
    void update(Long id,CompanyDto companyDto);
    void delete(Long id);
}
