package com.dbp.backendtourplus.company.infrastructure;

import com.dbp.backendtourplus.AbstractContainerBaseTest;
import com.dbp.backendtourplus.company.domain.Company;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class CompanyRepositoryTest extends AbstractContainerBaseTest {

    @Autowired
    private CompanyRepository companyRepository;

    private Company company;

    @BeforeEach
    void setUp() {
        company = new Company();
        company.setName("Test Company");
        company.setRuc("123456789");
        company.setEmail("test@example.com");
    }

    @Test
    void testSaveAndFindCompany() {
        Company company = new Company();
        company.setName("Test Company");
        company.setRuc("123456789");
        company.setEmail("test@example.com");

        Company savedCompany = companyRepository.save(company);

        Company foundCompany = companyRepository.findById(savedCompany.getId()).orElse(null);
        assertThat(foundCompany).isNotNull();
        assertThat(foundCompany.getName()).isEqualTo("Test Company");
        assertThat(foundCompany.getRuc()).isEqualTo("123456789");
        assertThat(foundCompany.getEmail()).isEqualTo("test@example.com");
    }


    @Test
    void testDeleteCompany() {
        Company company = new Company();
        company.setName("Test Company");
        company.setRuc("123456789");
        company.setEmail("test@example.com");

        Company savedCompany = companyRepository.save(company);

        assertThat(companyRepository.findById(savedCompany.getId())).isPresent();

        companyRepository.delete(savedCompany);

        assertThat(companyRepository.findById(savedCompany.getId())).isNotPresent();
    }

}