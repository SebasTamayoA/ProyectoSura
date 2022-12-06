package com.example.sura.controller;

import com.example.sura.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/vehiculos")
public class VehiculoController {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    // get all vehiculos

    // get vehiculo by id

    // create vehiculo

    // update vehiculo

    // delete vehiculo
}
