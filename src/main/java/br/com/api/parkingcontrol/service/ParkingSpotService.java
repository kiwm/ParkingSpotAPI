package br.com.api.parkingcontrol.service;

import br.com.api.parkingcontrol.model.ParkingSpotModel;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface ParkingSpotService {

    ParkingSpotModel save(ParkingSpotModel parkingSpotModel);

    List<ParkingSpotModel> findAll();
}
