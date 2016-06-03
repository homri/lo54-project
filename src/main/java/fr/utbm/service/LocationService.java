package fr.utbm.service;

import fr.utbm.repository.LocationDao;
import fr.utbm.entity.Location;

import java.util.List;

/**
 * Created by Iki on 03/06/2016.
 */
public class LocationService {
    private LocationDao LocationDao = new LocationDao();

    public List<Location> getAllLocationsService() {
        return LocationDao.getAllLocations();
    }

    public Location getLocationByIdService(int i){
        return LocationDao.getLocation(i);
    }
}
