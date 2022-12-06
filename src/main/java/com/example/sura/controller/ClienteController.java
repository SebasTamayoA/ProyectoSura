package com.example.sura.controller;

import com.example.sura.exception.ResourceNotFoundException;
import com.example.sura.model.Cliente;
import com.example.sura.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/clientes")
public class ClienteController {
    //implementación de controlador de cliente

    @Autowired
    private ClienteRepository clienteRepository;

    // get all clientes
    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    // create cliente
    @PostMapping
    public Cliente createCliente(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // get cliente by id
    @GetMapping(value = "{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente no existe con id: " + id));
        return ResponseEntity.ok(cliente);
    }

    // update cliente
    @PutMapping(value = "{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable Long id,@RequestBody Cliente clienteDetails){
        Cliente updateCliente = clienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente no existe con id: " + id));

        updateCliente.setNombre(clienteDetails.getNombre());
        updateCliente.setApellido(clienteDetails.getApellido());
        updateCliente.setContrasena(clienteDetails.getContrasena());
        updateCliente.setCorreo(clienteDetails.getCorreo());
        updateCliente.setTipoIdentificacion(clienteDetails.getTipoIdentificacion());
        updateCliente.setNumeroIdentificacion(clienteDetails.getNumeroIdentificacion());
        updateCliente.setDireccion(clienteDetails.getDireccion());

        clienteRepository.save(updateCliente);
        return ResponseEntity.ok(updateCliente);
    }

    // delete cliente
    @DeleteMapping(value = "{id}")
    public ResponseEntity<Cliente> deleteCliente(@PathVariable Long id){
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente no existe con id: " + id));
        clienteRepository.delete(cliente);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
