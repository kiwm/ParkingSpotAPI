package br.com.api.parkingcontrol.service;

import br.com.api.parkingcontrol.model.ParkingSpotModel;
import br.com.api.parkingcontrol.repository.ParkingSpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ParkingSpotServiceImp implements ParkingSpotService {


    @Autowired
    ParkingSpotRepository parkingSpotRepository;

    @Transactional
    @Override
    public ParkingSpotModel save(ParkingSpotModel parkingSpotModel) {
        return parkingSpotRepository.save(parkingSpotModel);
    }

    @Override
    public List<ParkingSpotModel> findAll() {
        return parkingSpotRepository.findAll();
    }


    public boolean existsByLicensePlateCar(String licensePlateCar) {
        return parkingSpotRepository.existsByLicensePlateCar(licensePlateCar);
    }


    public boolean existsByParkingSpotNumber(String parkingSpotNumber) {
        return parkingSpotRepository.existsByParkingSpotNumber(parkingSpotNumber);
    }

}
