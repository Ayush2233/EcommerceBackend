package com.example.demo.entities;

import jakarta.persistence.*;


/* This class if for converting the data from database into StateCity objects */

@Entity
@Table(name = "StateAndCity")
public class StateCityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String stateName;

    private String cityName;

    @ManyToOne
    @JoinColumn(name = "countryId",referencedColumnName = "id")
    private CountryEntity country;

    public StateCityEntity() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public CountryEntity getCountry() {
        return country;
    }

    public void setCountry(CountryEntity country) {
        this.country = country;
    }

    public StateCityEntity(int id, String stateName, String cityName, CountryEntity country) {
        this.id = id;
        this.stateName = stateName;
        this.cityName = cityName;
        this.country = country;
    }

//    @Override
//    public String toString() {
//        return "StateCityEntity{" +
//                "id=" + id +
//                ", stateName='" + stateName + '\'' +
//                ", cityName='" + cityName + '\'' +
//                ", country=" + country +
//                '}';
//    }
}
