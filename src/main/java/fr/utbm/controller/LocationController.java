package fr.utbm.controller;

import fr.utbm.entity.Location;
import fr.utbm.service.LocationService;

import java.util.List;

/**
 * Created by Iki on 03/06/2016.
 */
public class LocationController {

    private static LocationService locationService = new LocationService();

    public static List<Location> getAllLocations() {
        return locationService.getAllLocationsService();
    }

    public static Location getLocationById(int i){
        return locationService.getLocationByIdService(i);
    }
}
