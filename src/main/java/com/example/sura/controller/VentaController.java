package com.example.sura.controller;

import com.example.sura.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/ventas")
public class VentaController {

    @Autowired
    private VentaRepository ventaRepository;

    // get all ventas

    // get venta by id

    // create venta

    // update venta

    // delete venta
}
