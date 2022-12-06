package com.example.sura.controller;

import com.example.sura.model.Pago;
import com.example.sura.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/pagos")
public class PagoController {

    @Autowired
    private PagoRepository pagoRepository;

    // get all pagos
    @GetMapping
    public List<Pago> getAllPagos() {
        return pagoRepository.findAll();
    }

    // get pago by id
    @GetMapping(value = "{id}")
    public ResponseEntity<Pago> getPagoById(Long id) {
        Pago pago = pagoRepository.findById(id).orElseThrow( () -> new RuntimeException("No se encontro el pago con id: " + id));
        return ResponseEntity.ok(pago);
    }

    // create pago
    @PostMapping
    public Pago createPago(Pago pago) {
        return pagoRepository.save(pago);
    }

    // update pago
    @PutMapping(value = "{id}")
    public ResponseEntity<Pago> updatePago(@PathVariable("id") Long id, Pago pagoDetails) {
        Pago updatePago = pagoRepository.findById(id).orElseThrow( () -> new RuntimeException("No se encontro el pago con id: " + id));

        updatePago.setValor(pagoDetails.getValor());
        updatePago.setTipoPago(pagoDetails.getTipoPago());
        updatePago.setDetalle(pagoDetails.getDetalle());
        updatePago.setEstado(pagoDetails.getEstado());
        updatePago.setCodigoPago(pagoDetails.getCodigoPago());
        updatePago.setIdCliente(pagoDetails.getIdCliente());
        updatePago.setIdPoliza(pagoDetails.getIdPoliza());

        pagoRepository.save(updatePago);
        return ResponseEntity.ok(updatePago);
    }

    // delete pago
    @DeleteMapping(value = "{id}")
    public ResponseEntity<Pago> deletePago(Long id) {
        Pago pago = pagoRepository.findById(id).orElseThrow( () -> new RuntimeException("No se encontro el pago con id: " + id));
        pagoRepository.delete(pago);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
