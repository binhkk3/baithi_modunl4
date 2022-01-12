package com.example.thi_thuc_hanh.repository;

import com.example.thi_thuc_hanh.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICountryRepository extends JpaRepository<Country, Long> {
}
