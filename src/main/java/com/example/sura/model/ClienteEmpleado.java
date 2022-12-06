package com.example.sura.model;

import jakarta.persistence.*;

@Entity
@Table(name = "CLIENTE_EMPLEADO", schema = "CONEXION")
public class ClienteEmpleado {
    @Id
    @Column(name = "ID_CLIENTE_EMPLEADO", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_CLIENTE", nullable = false)
    private Cliente idCliente;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_EMPLEADO", nullable = false)
    private Empleado idEmpleado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Empleado getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Empleado idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

}