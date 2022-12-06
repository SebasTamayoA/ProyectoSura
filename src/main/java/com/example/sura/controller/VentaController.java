package com.example.sura.controller;

import com.example.sura.exception.ResourceNotFoundException;
import com.example.sura.model.Venta;
import com.example.sura.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/ventas")
public class VentaController {

    @Autowired
    private VentaRepository ventaRepository;

    // get all ventas
    @GetMapping
    public List<Venta> getAllVentas() {
        return ventaRepository.findAll();
    }

    // get venta by id
    @GetMapping(value = "{id}")
    public ResponseEntity<Venta> getVentaById(@PathVariable("id") Long id) {
        Venta venta = ventaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Venta no existe con id: " + id));
        return ResponseEntity.ok(venta);
    }

    // create venta
    @PostMapping
    public Venta createVenta(Venta venta) {
        return ventaRepository.save(venta);
    }

    // update venta
    @PutMapping(value = "{id}")
    public ResponseEntity<Venta> updateVenta(@PathVariable("id") Long id,@RequestBody Venta ventaDetails) {
        Venta updateVenta = ventaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Venta no existe con id: " + id));

        updateVenta.setFechaVenta(ventaDetails.getFechaVenta());
        updateVenta.setCodigoPago(ventaDetails.getCodigoPago());
        updateVenta.setIdPoliza(ventaDetails.getIdPoliza());
        updateVenta.setIdClienteEmpleado(ventaDetails.getIdClienteEmpleado());

        ventaRepository.save(updateVenta);
        return ResponseEntity.ok(updateVenta);
    }

    // delete venta
    @DeleteMapping(value = "{id}")
    public ResponseEntity<Venta> deleteVenta(@PathVariable("id") Long id) {
        Venta venta = ventaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Venta no existe con id: " + id));
        ventaRepository.delete(venta);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
