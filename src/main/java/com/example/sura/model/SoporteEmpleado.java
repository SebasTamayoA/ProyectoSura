package com.example.sura.model;

import jakarta.persistence.*;

@Entity
@Table(name = "SOPORTE_EMPLEADO", schema = "CONEXION")
public class SoporteEmpleado {
    @Id
    @Column(name = "ID_EMPLEADO_SOPORTE", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_CLIENTE", nullable = false)
    private Cliente idCliente;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_EMPLEADO", nullable = false)
    private Empleado idEmpleado;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_SOPORTE", nullable = false)
    private Soporte idSoporte;

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

    public Soporte getIdSoporte() {
        return idSoporte;
    }

    public void setIdSoporte(Soporte idSoporte) {
        this.idSoporte = idSoporte;
    }

}