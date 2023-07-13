package com.example.demo.repositories;

import com.example.demo.entities.CountryEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
/* This interface gives access to all CRUD operations on the Country table in database*/
public interface CountryRepository extends CrudRepository<CountryEntity,Integer>
{
    @Query(value="select name from country",nativeQuery = true)
    public List<String> getAllCountryName();

    @Query(value = "select id from country where name=?1",nativeQuery = true)
    public int getIdByName(String country);
}
