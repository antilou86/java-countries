package com.lambdaschool.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;

@RestController
@RequestMapping("/age")
public class AgeController {
    //localhost:8080/age/{age}
    @GetMapping(value="/{age}",
                produces = {"application/json"})
    public ResponseEntity<?> getMedianGreaterThanGiven(@PathVariable int age) {
        ArrayList<Country> ageList = CountriesApplication.myCountryList.findCountries(c -> c.getMedianAge() >= age);
        return new ResponseEntity<>(ageList, HttpStatus.OK);
    }
    //localhost:8080/age/min
    @GetMapping(value = "/min", produces = {"application/json"})
    public ResponseEntity<?> getMinAge() {
        ArrayList<Country> sortedAge = CountriesApplication.myCountryList.countryList;
        sortedAge.sort(Comparator.comparingInt(Country::getMedianAge));
        return new ResponseEntity<>(sortedAge.get(0),HttpStatus.OK);
    }
    //localhost:8080/age/max
    @GetMapping(value = "/max", produces = {"application/json"})
    public ResponseEntity<?> getMaxAge() {
        ArrayList<Country> sortedAge = CountriesApplication.myCountryList.countryList;
        sortedAge.sort(Comparator.comparingInt(Country::getMedianAge));
        int size = sortedAge.size()-1;
        return new ResponseEntity<>(sortedAge.get(size),HttpStatus.OK);
    }
    //localhost:8080/age/median ---stretch
}
