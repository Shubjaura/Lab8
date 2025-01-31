package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    @Test
    void testHasCity() {
        list = MockCityList();
        City city1 = new City("Winnipeg", "Manitoba");
        City city2 = new City("Calgary", "Alberta");

        list.addCity(city1);
        assertTrue(list.hasCity(city1), "City should be found in the list.");
        assertFalse(list.hasCity(city2), "City should be not found in the list.");
    }

    @Test
    void testDeleteCity() {
        list = MockCityList();
        City city = new City("Montreal", "Quebec");

        list.addCity(city);
        assertTrue(list.hasCity(city), "City should be in the list before deletion.");

        list.delete(city);
        assertFalse(list.hasCity(city), "City should be removed from the list.");
    }

    @Test
    void testCountCities() {
        list = MockCityList();

        list.addCity(new City("Edmonton", "Alberta"));
        list.addCity(new City("Regina", "Saskatchewan"));
        assertEquals(2, list.countCities(), "Count should be 2 after adding two cities.");
    }
}
