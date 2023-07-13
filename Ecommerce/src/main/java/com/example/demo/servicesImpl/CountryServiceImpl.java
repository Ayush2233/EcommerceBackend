package com.example.demo.servicesImpl;

import com.example.demo.repositories.CountryRepository;
import com.example.demo.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
/*This class implements the methods of the Country service interface*/
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;
    @Override
    public List<String> getAllCountries()
    {
       return countryRepository.getAllCountryName();
    }
}
