package com.example.sura.controller;

import com.example.sura.exception.ResourceNotFoundException;
import com.example.sura.model.SoporteEmpleado;
import com.example.sura.repository.SoporteEmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/soporte-empleado")
public class SoporteEmpleadoController {

    @Autowired
    private SoporteEmpleadoRepository soporteEmpleadoRepository;

    // get all soporte-empleados
    @GetMapping
    public List<SoporteEmpleado> getAllSoporteEmpleados() {
        return soporteEmpleadoRepository.findAll();
    }

    // get soporte-empleado by id
    @GetMapping(value = "{id}")
    public ResponseEntity<SoporteEmpleado> getSoporteEmpleadoById(@PathVariable("id") Long id) {
        SoporteEmpleado soporteEmpleado = soporteEmpleadoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("SoporteEmpleado no existe con id: " + id));
        return ResponseEntity.ok(soporteEmpleado);
    }


    // create soporte-empleado
    @PostMapping
    public SoporteEmpleado createSoporteEmpleado(SoporteEmpleado soporteEmpleado) {
        return soporteEmpleadoRepository.save(soporteEmpleado);
    }

    // update soporte-empleado
    @PutMapping(value = "{id}")
    public ResponseEntity<SoporteEmpleado> updateSoporteEmpleado(@PathVariable("id") Long id,@RequestBody SoporteEmpleado soporteEmpleadoDetails) {
        SoporteEmpleado updateSoporteEmpleado = soporteEmpleadoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("SoporteEmpleado no existe con id: " + id));

        updateSoporteEmpleado.setIdCliente(soporteEmpleadoDetails.getIdCliente());
        updateSoporteEmpleado.setIdEmpleado(soporteEmpleadoDetails.getIdEmpleado());
        updateSoporteEmpleado.setIdSoporte(soporteEmpleadoDetails.getIdSoporte());

        soporteEmpleadoRepository.save(updateSoporteEmpleado);
        return ResponseEntity.ok(updateSoporteEmpleado);
    }

    // delete soporte-empleado
    @DeleteMapping(value = "{id}")
    public ResponseEntity<SoporteEmpleado> deleteSoporteEmpleado(@PathVariable("id") Long id) {
        SoporteEmpleado soporteEmpleado = soporteEmpleadoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("SoporteEmpleado no existe con id: " + id));
        soporteEmpleadoRepository.delete(soporteEmpleado);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }


}
