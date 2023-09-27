package com.JamieSatchell.ims.Services;

import com.JamieSatchell.ims.domain.Location;
import com.JamieSatchell.ims.repositories.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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


    public void deleteLocationById(Long id) throws Exception {
        Optional<Location> locationOptional = locationRepository.findById(id);
        if(locationOptional.isPresent()) {
            Location location = locationOptional.get();
            if(location.getStock().isEmpty()) {
                locationRepository.deleteById(id);
            } else {
                throw new Exception("Cannot delete location as it has associated stock items.");
            }
        } else {
            throw new Exception("Location with id " + id + " not found.");
        }
    }
}
