package com.example.sura.model;

import jakarta.persistence.*;

@Entity
@Table(name = "POLIZAS", schema = "CONEXION")
public class Poliza {
    @Id
    @Column(name = "ID_POLIZA", nullable = false)
    private Long id;

    @Column(name = "COSTO", nullable = false)
    private Float costo;

    @Column(name = "VIGENCIA", nullable = false)
    private Long vigencia;

    @Column(name = "TIPO_POLIZA", nullable = false, length = 25)
    private String tipoPoliza;

    @Column(name = "DESCRIPCION", nullable = false, length = 1000)
    private String descripcion;

    @Column(name = "ESTADO")
    private Long estado;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_CLIENTE", nullable = false)
    private Cliente idCliente;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_VEHICULO", nullable = false)
    private Vehiculo idVehiculo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getCosto() {
        return costo;
    }

    public void setCosto(Float costo) {
        this.costo = costo;
    }

    public Long getVigencia() {
        return vigencia;
    }

    public void setVigencia(Long vigencia) {
        this.vigencia = vigencia;
    }

    public String getTipoPoliza() {
        return tipoPoliza;
    }

    public void setTipoPoliza(String tipoPoliza) {
        this.tipoPoliza = tipoPoliza;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getEstado() {
        return estado;
    }

    public void setEstado(Long estado) {
        this.estado = estado;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Vehiculo getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Vehiculo idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

}