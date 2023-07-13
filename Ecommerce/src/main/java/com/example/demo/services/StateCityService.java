package com.example.demo.services;


import java.util.List;

/*This is the service interface where all the methods related to StateCity table are defined*/
public interface StateCityService
{
    List<String> getStateBycountry(String country);

    List<String> getCityByState(String state);
}
