package com.example.sura.controller;


import com.example.sura.exception.ResourceNotFoundException;
import com.example.sura.model.Empleado;
import com.example.sura.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    // get all empleados
    @GetMapping
    public List<Empleado> getAllEmpleados() {
        return empleadoRepository.findAll();
    }

    // get empleado by id
    @GetMapping(value = "{id}")
    public ResponseEntity<Empleado> getEmpleadoById(@PathVariable("id") Long id) {
        Empleado empleado = empleadoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Empleado no existe con id: " + id));
        return ResponseEntity.ok(empleado);
    }

    // create empleado
    @PostMapping
    public Empleado createEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    // update empleado
    @PutMapping(value = "{id}")
    public ResponseEntity<Empleado> updateEmpleado(@PathVariable("id") Long id,@RequestBody Empleado empleadoDetails) {
        Empleado updateEmpleado = empleadoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Empleado no existe con id: " + id));

        updateEmpleado.setNombre(empleadoDetails.getNombre());
        updateEmpleado.setApellido(empleadoDetails.getApellido());
        updateEmpleado.setDireccion(empleadoDetails.getDireccion());
        updateEmpleado.setCorreo(empleadoDetails.getCorreo());
        updateEmpleado.setTelefono(empleadoDetails.getTelefono());

        empleadoRepository.save(updateEmpleado);
        return ResponseEntity.ok(updateEmpleado);
    }

    // delete empleado
    @DeleteMapping(value = "{id}")
    public ResponseEntity<Empleado> deleteEmpleado(@PathVariable("id") Long id) {
        Empleado empleado = empleadoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Empleado no existe con id: " + id));
        empleadoRepository.delete(empleado);
        return ResponseEntity.ok(empleado);
    }
}
