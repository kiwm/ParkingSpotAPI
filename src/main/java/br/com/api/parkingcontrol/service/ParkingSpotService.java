package br.com.api.parkingcontrol.service;

import br.com.api.parkingcontrol.model.ParkingSpotModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface ParkingSpotService {

    ParkingSpotModel save(ParkingSpotModel parkingSpotModel);

    List<ParkingSpotModel> findAll();

    Optional<ParkingSpotModel> findById(UUID id);

    void delete(ParkingSpotModel parkingSpotModel);
}
