package com.example.demo.controller;

import com.example.demo.servicesImpl.CountryServiceImpl;
import com.example.demo.servicesImpl.StateCityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
@CrossOrigin(origins = "http://localhost:4200/")
public class AddressController
{
    @Autowired
    private CountryServiceImpl countryService;

    @Autowired
    private StateCityServiceImpl stateCityService;

    @GetMapping("/country")
    public List<String> getAllCountry()
    {
        return countryService.getAllCountries();
    }

    @GetMapping("/state")
    public List<String> getStateByCountry(@RequestParam String country)
    {
        return stateCityService.getStateBycountry(country);
    }

    @GetMapping("/city")
    public List<String> getCityByState(@RequestParam String state)
    {
        return stateCityService.getCityByState(state);
    }
}
