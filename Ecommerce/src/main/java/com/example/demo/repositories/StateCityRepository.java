package com.example.demo.repositories;

import com.example.demo.entities.StateCityEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
/* This interface gives access to all CRUD operations on the State and City table in database*/
public interface StateCityRepository extends CrudRepository<StateCityEntity,Integer> {

    @Query(value = "select * from state_and_city  where city_name=?1 and state_name=?2",nativeQuery = true)
    StateCityEntity findByName(String city,String state);

    @Query(value = "select distinct state_name from state_and_city  where country_id=?1",nativeQuery = true)
    List<String> getStateByCountry(int country);

    @Query(value = "select distinct city_name from state_and_city  where state_name=?1",nativeQuery = true)
    List<String> getCityByState(String state);


}
