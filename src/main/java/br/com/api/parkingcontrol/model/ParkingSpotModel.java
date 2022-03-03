package br.com.api.parkingcontrol.model;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Entity
public class ParkingSpotModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "uuid", columnDefinition = "char(36)")
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;

    @Column(unique = true)
    private String parkingSpotNumber;

    @Column(unique = true)
    private String licensePlateCar;

    private String modelCar;

    private String responsibleNumber;

    private String apartment;

}
