package com.example.sura.controller;

import com.example.sura.repository.SoporteEmpleadoRepository;
import com.example.sura.repository.SoporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/soporte")
public class SoporteController {

    @Autowired
    private SoporteRepository soporteRepository;

    // get all soportes

    // get soporte by id

    // create soporte

    // update soporte
}
