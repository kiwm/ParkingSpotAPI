package br.com.api.parkingcontrol.controller;

import br.com.api.parkingcontrol.dto.ParkingSpotDto;
import br.com.api.parkingcontrol.model.ParkingSpotModel;
import br.com.api.parkingcontrol.service.ParkingSpotServiceImp;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/parking-spot")
public class ParkingSpotController {

    @Autowired
    ParkingSpotServiceImp parkingSpotServiceImp;


    @PostMapping
    public ResponseEntity<Object> saveParkingSpot(@RequestBody @Valid ParkingSpotDto parkingSpotDto) {

        if(parkingSpotServiceImp.existsByLicensePlateCar(parkingSpotDto.getLicensePlateCar())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: License Plate Car is already in use!");
        }

        if(parkingSpotServiceImp.existsByParkingSpotNumber(parkingSpotDto.getParkingSpotNumber())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: parking spot already in use!");
        }

        ParkingSpotModel parkingSpotModel = new ParkingSpotModel();
        BeanUtils.copyProperties(parkingSpotDto, parkingSpotModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotServiceImp.save(parkingSpotModel));
    }

    @GetMapping
    public ResponseEntity<List<ParkingSpotModel>> getAllParkingSpots() {
        return ResponseEntity.status(HttpStatus.OK).body(parkingSpotServiceImp.findAll());
    }
}
