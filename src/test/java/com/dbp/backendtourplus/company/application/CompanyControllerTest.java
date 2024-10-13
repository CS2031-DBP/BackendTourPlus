package com.dbp.backendtourplus.company.application;

import com.dbp.backendtourplus.company.domain.Company;
import com.dbp.backendtourplus.company.domain.CompanyService;
import com.dbp.backendtourplus.company.dto.CompanyDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CompanyControllerTest {

    @InjectMocks
    private CompanyController companyController;

    @Mock
    private CompanyService companyService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllCompanies() {
        when(companyService.getAllCompanies()).thenReturn(Collections.singletonList(new Company()));

        var companies = companyController.getAllCompanies();
        assertThat(companies).isNotEmpty();
        verify(companyService, times(1)).getAllCompanies();
    }

    @Test
    void testGetCompanyById() {
        Company company = new Company();
        company.setId(1L);
        when(companyService.getCompanyById(1L)).thenReturn(Optional.of(company));

        var response = companyController.getCompanyById(1L);
        assertThat(response.getStatusCode().value()).isEqualTo(200);
        verify(companyService, times(1)).getCompanyById(1L);
    }

    @Test
    void testCreateCompany() {
        CompanyDto companyDto = new CompanyDto();
        companyDto.setName("Test Company");
        companyDto.setRuc("123456789");
        companyDto.setEmail("test@example.com");

        Company company = new Company();
        company.setId(1L);
        company.setName(companyDto.getName());
        company.setRuc(companyDto.getRuc());
        company.setEmail(companyDto.getEmail());

        when(companyService.createCompany(any(), any(), any(), any())).thenReturn(company);

        var response = companyController.createCompany(companyDto);
        assertThat(response.getName()).isEqualTo("Test Company");
        verify(companyService, times(1)).createCompany(any(), any(), any(), any());
    }

    @Test
    void testUpdateCompany() {
        Company existingCompany = new Company();
        existingCompany.setId(1L);
        existingCompany.setName("Old Company");
        existingCompany.setRuc("987654321");
        existingCompany.setEmail("old@example.com");

        when(companyService.getCompanyById(1L)).thenReturn(Optional.of(existingCompany));

        CompanyDto updatedDto = new CompanyDto();
        updatedDto.setName("Updated Company");
        updatedDto.setRuc("123456789");
        updatedDto.setEmail("updated@example.com");

        var response = companyController.updateCompany(1L, updatedDto);
        assertThat(response.getStatusCode().value()).isEqualTo(200);
        verify(companyService, times(1)).updateCompany(any(), any(), any(), any());
    }

    @Test
    void testDeleteCompany() {
        when(companyService.getCompanyById(1L)).thenReturn(Optional.of(new Company()));

        var response = companyController.deleteCompany(1L);
        assertThat(response.getStatusCode().value()).isEqualTo(204);
        verify(companyService, times(1)).deleteCompany(1L);
    }
}
