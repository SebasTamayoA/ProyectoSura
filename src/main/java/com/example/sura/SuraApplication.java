package com.example.sura;

import com.example.sura.model.Cliente;
import com.example.sura.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SuraApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SuraApplication.class, args);
    }

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public void run(String... args) throws Exception {
//        Cliente cliente = new Cliente();
//        cliente.setNombre("Juan");
//        cliente.setApellido("Perez");
//        clienteRepository.save(cliente);

    }
}
