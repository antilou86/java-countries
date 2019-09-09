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
@RequestMapping("/population")
public class PopulationController {
    //localhost:8080/population/size/{people}
    @GetMapping(value ="/size/{people}",
                produces={"application/json"})
    public ResponseEntity<?> getPopulationByPop(@PathVariable int people) {
        ArrayList<Country> pop = CountriesApplication.myCountryList.findCountries(c -> c.getPopulation() >= people);
        return new ResponseEntity<>(pop, HttpStatus.OK);
    }

    //localhost:8080/population/min
    @GetMapping(value = "/min",
                produces = {"application/json"})
    public ResponseEntity<?> getMinPop() {
        ArrayList<Country> sortedPop = CountriesApplication.myCountryList.countryList;
        sortedPop.sort(Comparator.comparingInt(Country::getPopulation));
        return new ResponseEntity<>(sortedPop.get(0),HttpStatus.OK);
    }
    //localhost:8080/population/max
    @GetMapping(value = "/max",
            produces = {"application/json"})
    public ResponseEntity<?> getMaxPop() {
        ArrayList<Country> sortedPop = CountriesApplication.myCountryList.countryList;
        sortedPop.sort(Comparator.comparingInt(Country::getPopulation));
        return new ResponseEntity<>(sortedPop.get(sortedPop.size()),HttpStatus.OK);
    }
    //localhost:8080/population/median ---stretch

}
