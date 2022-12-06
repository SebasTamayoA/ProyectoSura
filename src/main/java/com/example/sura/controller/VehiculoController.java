package com.example.sura.controller;

import com.example.sura.exception.ResourceNotFoundException;
import com.example.sura.model.Vehiculo;
import com.example.sura.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/vehiculos")
public class VehiculoController {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    // get all vehiculos
    @GetMapping
    public List<Vehiculo> getAllVehiculos() {
        return vehiculoRepository.findAll();
    }

    // get vehiculo by id
    @GetMapping(value = "{id}")
    public ResponseEntity<Vehiculo> getVehiculoById(@PathVariable("id") Long id) {
        Vehiculo vehiculo = vehiculoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Vehiculo no existe con id: " + id));
        return ResponseEntity.ok(vehiculo);
    }

    // create vehiculo
    @PostMapping
    public Vehiculo createVehiculo(Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }

    // update vehiculo
    @PutMapping(value = "{id}")
    public ResponseEntity<Vehiculo> updateVehiculo(@PathVariable("id") Long id,@RequestBody Vehiculo vehiculoDetails) {
        Vehiculo updateVehiculo = vehiculoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Vehiculo no existe con id: " + id));

        updateVehiculo.setTipoVehiculo(vehiculoDetails.getTipoVehiculo());
        updateVehiculo.setPlaca(vehiculoDetails.getPlaca());
        updateVehiculo.setChasis(vehiculoDetails.getChasis());
        updateVehiculo.setCilindraje(vehiculoDetails.getCilindraje());
        updateVehiculo.setMarca(vehiculoDetails.getMarca());
        updateVehiculo.setModelo(vehiculoDetails.getModelo());
        updateVehiculo.setColor(vehiculoDetails.getColor());

        vehiculoRepository.save(updateVehiculo);
        return ResponseEntity.ok(updateVehiculo);
    }

    // delete vehiculo
    @DeleteMapping(value = "{id}")
    public ResponseEntity<Vehiculo> deleteVehiculo(@PathVariable("id") Long id) {
        Vehiculo vehiculo = vehiculoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Vehiculo no existe con id: " + id));
        vehiculoRepository.delete(vehiculo);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
