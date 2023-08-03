package com.example.company_management.service.impl;

import com.example.company_management.dto.CompanyDto;
import com.example.company_management.entity.Company;
import com.example.company_management.map.CompanyMap;
import com.example.company_management.repository.CompanyRepository;
import com.example.company_management.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository repository;
    private final CompanyMap map;

    @Override
    public List<CompanyDto> findAll(){
        return repository.findAll().stream()
                .map(map::toDto)
                .toList();
    }
    @Override
    public CompanyDto findById(Long id){
        Company search= repository
                .findById(id).orElseThrow();
        return map.toDto(search);
    }
    @Override
    @Transactional(rollbackFor = SQLException.class)
    public void save(CompanyDto companyDto){
         Company company=map.toEntity(companyDto);
        try {
            repository.save(company);
        }catch (RuntimeException exception){
            throw new RuntimeException("Save zamani xeta bash verdi");
        }
    }

    @Override
    @Transactional()
    public void update(Long id, CompanyDto companyDto) {
        Company company=repository.findById(id).orElseThrow();
        company.setName(companyDto.getName());
        company.setCreate_date(LocalDate.ofEpochDay(id));

        try{
            repository.save(company);
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
