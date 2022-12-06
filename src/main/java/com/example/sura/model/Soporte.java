package com.example.sura.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "SOPORTES", schema = "CONEXION")
public class Soporte {
    @Id
    @Column(name = "ID_SOPORTE", nullable = false)
    private Long id;

    @Column(name = "FECHA_SOPORTE", nullable = false)
    private LocalDate fechaSoporte;

    @Column(name = "DESCRIPCION", nullable = false, length = 4000)
    private String descripcion;

    @Column(name = "TIPO_SOPORTE", nullable = false, length = 100)
    private String tipoSoporte;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_CLIENTE_EMPLEADO", nullable = false)
    private ClienteEmpleado idClienteEmpleado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFechaSoporte() {
        return fechaSoporte;
    }

    public void setFechaSoporte(LocalDate fechaSoporte) {
        this.fechaSoporte = fechaSoporte;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoSoporte() {
        return tipoSoporte;
    }

    public void setTipoSoporte(String tipoSoporte) {
        this.tipoSoporte = tipoSoporte;
    }

    public ClienteEmpleado getIdClienteEmpleado() {
        return idClienteEmpleado;
    }

    public void setIdClienteEmpleado(ClienteEmpleado idClienteEmpleado) {
        this.idClienteEmpleado = idClienteEmpleado;
    }

}