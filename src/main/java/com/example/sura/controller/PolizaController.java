package com.example.sura.controller;

import com.example.sura.repository.PolizaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/polizas")
public class PolizaController {

    @Autowired
    private PolizaRepository polizaRepository;

    // get all polizas

    // get poliza by id

    // create poliza

    // update poliza

    // delete poliza
}
