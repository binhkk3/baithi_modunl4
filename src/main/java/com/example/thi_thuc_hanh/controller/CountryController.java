package com.example.thi_thuc_hanh.controller;

import com.example.thi_thuc_hanh.model.Country;
import com.example.thi_thuc_hanh.model.Country;
import com.example.thi_thuc_hanh.service.ICityService;
import com.example.thi_thuc_hanh.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/countries")
public class CountryController {

    @Autowired
    ICountryService countryService;

    @GetMapping("")
    public ResponseEntity<Iterable<Country>> findAll() {

        Iterable<Country> countryIterable = countryService.findAll();
        return new ResponseEntity<>(countryIterable, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Country> create(@RequestBody Country country) {
        countryService.save(country);
        return new ResponseEntity<>(country, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Country> update(@PathVariable Long id, @RequestBody Country country) {
        country.setId(id);
        countryService.save(country);
        return new ResponseEntity<>(country, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Country> delete(@PathVariable Long id) {
        countryService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> findOne(@PathVariable Long id) {
        Optional<Country> countryOptional = countryService.findById(id);
        return new ResponseEntity<>(countryOptional.get(), HttpStatus.OK);
    }
}
