package com.dbp.backendtourplus.company.application;

import com.dbp.backendtourplus.company.domain.Company;
import com.dbp.backendtourplus.company.domain.CompanyService;
import com.dbp.backendtourplus.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public List<Company> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id) {
        return companyService.getCompanyById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("Company not found with id " + id));
    }

    @PostMapping
    public Company createCompany(@RequestParam Long userId, @RequestParam String name, @RequestParam String ruc) {
        return companyService.createCompany(userId, name, ruc);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Company> updateCompany(@PathVariable Long id, @RequestParam String name, @RequestParam String ruc) {
        return ResponseEntity.ok(companyService.updateCompany(id, name, ruc));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable Long id) {
        companyService.deleteCompany(id);
        return ResponseEntity.noContent().build();
    }
}
