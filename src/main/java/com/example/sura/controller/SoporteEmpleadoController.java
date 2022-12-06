package com.example.sura.controller;

import com.example.sura.repository.SoporteEmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/soporte-empleado")
public class SoporteEmpleadoController {

    @Autowired
    private SoporteEmpleadoRepository soporteEmpleadoRepository;

    // get all soporte-empleados

    // get soporte-empleado by id

    // create soporte-empleado

    // update soporte-empleado

    // delete soporte-empleado


}
