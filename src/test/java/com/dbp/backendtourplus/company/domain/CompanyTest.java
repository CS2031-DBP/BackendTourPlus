package com.dbp.backendtourplus.company.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CompanyTest {

    @Test
    void testGettersAndSetters() {
        Company company = new Company();
        company.setName("Test Company");
        company.setRuc("123456789");
        company.setEmail("test@example.com");

        assertEquals("Test Company", company.getName());
        assertEquals("123456789", company.getRuc());
        assertEquals("test@example.com", company.getEmail());
    }
}
