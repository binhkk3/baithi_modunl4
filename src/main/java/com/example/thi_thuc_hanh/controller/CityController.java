package com.example.thi_thuc_hanh.controller;

import com.example.thi_thuc_hanh.model.City;
import com.example.thi_thuc_hanh.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/cities")
public class CityController {
    @Autowired
    ICityService iCityService;

    @GetMapping("")
    public ResponseEntity<Iterable<City>> findAll() {

        Iterable<City> cityIterable = iCityService.findAll();
        return new ResponseEntity<>(cityIterable, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<City> create(@RequestBody City city) {
        iCityService.save(city);
        return new ResponseEntity<>(city, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<City> update(@PathVariable Long id, @RequestBody City city) {
        city.setId(id);
        iCityService.save(city);
        return new ResponseEntity<>(city, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<City> delete(@PathVariable Long id) {
        iCityService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> findOne(@PathVariable Long id) {
        Optional<City> cityOptional = iCityService.findById(id);
        return new ResponseEntity<>(cityOptional.get(), HttpStatus.OK);
    }
//    @GetMapping("/search/{key}")
//    public ResponseEntity<Iterable<City>> findByNameContaining(String key){
//        Iterable<City> cityIterable=   iCityService.findByNameContaining(key);
//        return  new ResponseEntity<>(cityIterable,HttpStatus.OK);
//    }
//    @GetMapping("/sort")
//    public ResponseEntity<Iterable<City>> sortByName(){
//        Iterable<City> cityIterable= iCityService.findAllByOrderByNameAsc();
//        return new ResponseEntity<>(clazzIterable, HttpStatus.OK);
//    }

}
