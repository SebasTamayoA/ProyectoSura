package com.example.sura.controller;

import com.example.sura.exception.ResourceNotFoundException;
import com.example.sura.model.Soporte;
import com.example.sura.repository.SoporteEmpleadoRepository;
import com.example.sura.repository.SoporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/soporte")
public class SoporteController {

    @Autowired
    private SoporteRepository soporteRepository;

    // get all soportes
    @GetMapping
    public List<Soporte> getAllSoportes() {
        return soporteRepository.findAll();
    }

    // get soporte by id
    @GetMapping(value = "{id}")
    public ResponseEntity<Soporte> getSoporteById(@PathVariable("id") Long id) {
        Soporte soporte = soporteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Soporte no existe con id: " + id));
        return ResponseEntity.ok(soporte);
    }

    // create soporte
    @PostMapping
    public Soporte createSoporte(Soporte soporte) {
        return soporteRepository.save(soporte);
    }

    // update soporte
    @PutMapping(value = "{id}")
    public ResponseEntity<Soporte> updateSoporte(@PathVariable("id") Long id,@RequestBody Soporte soporteDetails) {
        Soporte updateSoporte = soporteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Soporte no existe con id: " + id));

        updateSoporte.setFechaSoporte(soporteDetails.getFechaSoporte());
        updateSoporte.setDescripcion(soporteDetails.getDescripcion());
        updateSoporte.setTipoSoporte(soporteDetails.getTipoSoporte());
        updateSoporte.setIdClienteEmpleado(soporteDetails.getIdClienteEmpleado());

        soporteRepository.save(updateSoporte);
        return ResponseEntity.ok(updateSoporte);
    }

    // delete soporte
    @DeleteMapping(value = "{id}")
    public ResponseEntity<Soporte> deleteSoporte(@PathVariable("id") Long id) {
        Soporte soporte = soporteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Soporte no existe con id: " + id));
        soporteRepository.delete(soporte);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
