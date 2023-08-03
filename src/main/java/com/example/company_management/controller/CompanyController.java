package com.example.company_management.controller;

import com.example.company_management.dto.CompanyDto;
import com.example.company_management.service.impl.CompanyServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/companies")
public class CompanyController {
    private final CompanyServiceImpl companyService;

    @GetMapping
    public ResponseEntity<List<CompanyDto>> findAll() {
        return ResponseEntity.ok(companyService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyDto> findById(@PathVariable(name = "id") Long id){
        return ResponseEntity.ok(companyService.findById(id));
    }

    @PostMapping
    public ResponseEntity save(@RequestBody CompanyDto companyDto){
        companyService.save(companyDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable(name = "id") Long id,@RequestBody CompanyDto companydto){
        companyService.update(id,companydto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable(name = "id") Long id){
        companyService.delete(id);
    }
}
