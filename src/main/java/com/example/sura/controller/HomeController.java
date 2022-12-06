package com.example.sura.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(){
        return "Index";
    }

    @GetMapping("/login")
    public String login(){
        return "Login";
    }

    @GetMapping("/inicio")
    public String inicio(){
        return "inicio";
    }

    @GetMapping("/pago")
    public String pago(){
        return "Pago";
    }

    @GetMapping("/poliza")
    public String poliza(){
        return "Polizas";
    }

    @GetMapping("/registro")
    public String registro(){
        return "Registro";
    }
}
