/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.entity;

/**
 *
 * @author khalil
 */
public class Location {
    int id_location;
    String city;

    public int getId_location() {
        return id_location;
    }

    public String getCity() {
        return city;
    }

    public void setId_location(int id_location) {
        this.id_location = id_location;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
}
