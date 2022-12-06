package com.example.sura.controller;

import com.example.sura.exception.ResourceNotFoundException;
import com.example.sura.model.Poliza;
import com.example.sura.repository.PolizaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/polizas")
public class PolizaController {

    @Autowired
    private PolizaRepository polizaRepository;

    // get all polizas
    @GetMapping
    public List<Poliza> getAllPolizas() {
        return polizaRepository.findAll();
    }

    // get poliza by id
    @GetMapping(value = "{id}")
    public ResponseEntity<Poliza> getPolizaById(@PathVariable("id") Long id) {
        Poliza poliza = polizaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Poliza no existe con id: " + id));
        return ResponseEntity.ok(poliza);
    }

    // create poliza
    @PostMapping
    public Poliza createPoliza(Poliza poliza) {
        return polizaRepository.save(poliza);
    }

    // update poliza
    @PutMapping(value = "{id}")
    public ResponseEntity<Poliza> updatePoliza(@PathVariable("id") Long id,@RequestBody Poliza polizaDetails) {
        Poliza updatePoliza = polizaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Poliza no existe con id: " + id));

        updatePoliza.setCosto(polizaDetails.getCosto());
        updatePoliza.setVigencia(polizaDetails.getVigencia());
        updatePoliza.setTipoPoliza(polizaDetails.getTipoPoliza());
        updatePoliza.setDescripcion(polizaDetails.getDescripcion());
        updatePoliza.setEstado(polizaDetails.getEstado());
        updatePoliza.setIdCliente(polizaDetails.getIdCliente());
        updatePoliza.setIdVehiculo(polizaDetails.getIdVehiculo());

        polizaRepository.save(updatePoliza);
        return ResponseEntity.ok(updatePoliza);

    }

    // delete poliza
    @DeleteMapping(value = "{id}")
    public ResponseEntity<Poliza> deletePoliza(@PathVariable("id") Long id) {
        Poliza poliza = polizaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Poliza no existe con id: " + id));
        polizaRepository.delete(poliza);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
