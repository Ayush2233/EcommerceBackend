package com.example.demo.servicesImpl;


import com.example.demo.repositories.CountryRepository;
import com.example.demo.repositories.StateCityRepository;
import com.example.demo.services.StateCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
/*This class implements the methods of the StateCity service interface*/
public class StateCityServiceImpl implements StateCityService {

    @Autowired
    private StateCityRepository stateCityRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public List<String> getStateBycountry(String country) {
        int countryId=countryRepository.getIdByName(country);
        return stateCityRepository.getStateByCountry(countryId);
    }

    @Override
    public List<String> getCityByState(String state) {
        return stateCityRepository.getCityByState(state);
    }
}
