package com.example.sura.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "VEHICULOS", schema = "CONEXION")
public class Vehiculo {
    @Id
    @Column(name = "ID_VEHICULO", nullable = false)
    private Long id;

    @Column(name = "TIPO_VEHICULO", nullable = false, length = 30)
    private String tipoVehiculo;

    @Column(name = "PLACA", nullable = false, length = 6)
    private String placa;

    @Column(name = "CHASIS", nullable = false, length = 25)
    private String chasis;

    @Column(name = "CILINDRAJE", nullable = false, length = 10)
    private String cilindraje;

    @Column(name = "MODELO", nullable = false, length = 30)
    private String modelo;

    @Column(name = "COLOR", nullable = false, length = 30)
    private String color;

    @Column(name = "MARCA", nullable = false, length = 30)
    private String marca;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getChasis() {
        return chasis;
    }

    public void setChasis(String chasis) {
        this.chasis = chasis;
    }

    public String getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(String cilindraje) {
        this.cilindraje = cilindraje;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

}