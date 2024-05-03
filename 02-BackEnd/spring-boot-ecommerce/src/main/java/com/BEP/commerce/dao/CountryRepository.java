package com.BEP.commerce.dao;

import com.BEP.commerce.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
public interface CountryRepository extends JpaRepository<Country, Long> {
}
