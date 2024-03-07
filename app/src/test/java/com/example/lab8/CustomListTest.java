package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;

    /**
     * create a mocklist for my customlist
     * @return
     * an empty CustomList object
     */
    public CustomList MockCityList() {
        list = new CustomList(null, new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus one
     */
    @Test
    public void addCityTest() {
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(), listSize+1);
    }

    @Test
    public void testDeleteCity() {
        list = MockCityList();
        int listSize = list.getCount();
        City city1 = new City("Estevan", "SK");
        list.addCity(city1);
        list.deleteCity(city1);
        assertEquals(listSize, list.getCount());
    }

    @Test
    public void testHasCity() {
        list = MockCityList();
        City city1 = new City("Edmonton", "AB");
        list.addCity(city1);
        assertTrue(list.hasCity(city1));
        City city2 = new City("Charlottetown", "Prince Edward Island");
        assertTrue(!list.hasCity(city2));
    }

    @Test
    public void testCountCities() {
        list = MockCityList();
        City city1 = new City("Edmonton", "AB");
        list.addCity(city1);
        assertEquals(1, list.countCities());
        City city2 = new City("Charlottetown", "Prince Edward Island");
        list.addCity(city2);
        assertEquals(2, list.countCities());
        list.deleteCity(city1);
        list.deleteCity(city2);
        assertEquals(0, list.countCities());
    }
}
