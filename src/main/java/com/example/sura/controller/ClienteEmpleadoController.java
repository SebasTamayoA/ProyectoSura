package com.example.sura.controller;

import com.example.sura.exception.ResourceNotFoundException;
import com.example.sura.model.ClienteEmpleado;
import com.example.sura.repository.ClienteEmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/clientes-empleados")
public class ClienteEmpleadoController {

    //implementación de controlador de cliente-empleado

    @Autowired
    private ClienteEmpleadoRepository clienteEmpleadoRepository;

    // get all clientes-empleados
    @GetMapping
    public List<ClienteEmpleado> getAllClientesEmpleados() {
        return clienteEmpleadoRepository.findAll();
    }

    // get cliente-empleado by id
    @GetMapping(value = "{id}")
    public ResponseEntity<ClienteEmpleado> getClienteEmpleadoById(@PathVariable Long id) {
        ClienteEmpleado clienteEmpleado = clienteEmpleadoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente no existe con id: " + id));
        return ResponseEntity.ok(clienteEmpleado);
    }

    // create cliente-empleado
    @PostMapping
    public ClienteEmpleado createClienteEmpleado(ClienteEmpleado clienteEmpleado) {
        return clienteEmpleadoRepository.save(clienteEmpleado);
    }

    // update cliente-empleado
    @PutMapping(value = "{id}")
    public ResponseEntity<ClienteEmpleado> updateClienteEmpleado(@PathVariable Long id,@RequestBody ClienteEmpleado clienteEmpleadoDetails) {
        ClienteEmpleado updateClienteEmpleado = clienteEmpleadoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente no existe con id: " + id));

        updateClienteEmpleado.setIdCliente(clienteEmpleadoDetails.getIdCliente());
        updateClienteEmpleado.setIdEmpleado(clienteEmpleadoDetails.getIdEmpleado());

        clienteEmpleadoRepository.save(updateClienteEmpleado);
        return ResponseEntity.ok(updateClienteEmpleado);
    }

    // delete cliente-empleado
    @DeleteMapping(value = "{id}")
    public ResponseEntity<ClienteEmpleado> deleteClienteEmpleado(@PathVariable Long id) {
        ClienteEmpleado clienteEmpleado = clienteEmpleadoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente no existe con id: " + id));
        clienteEmpleadoRepository.delete(clienteEmpleado);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
