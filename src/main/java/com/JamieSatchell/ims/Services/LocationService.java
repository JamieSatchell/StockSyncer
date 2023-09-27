package com.JamieSatchell.ims.Services;

import com.JamieSatchell.ims.domain.Location;
import com.JamieSatchell.ims.repositories.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Location findLocationById(Long id) {
        return locationRepository.findById(id).orElse(null);
    }


    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    public void addLocation(Location location) {
        locationRepository.save(location);
    }
}
