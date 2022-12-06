package com.example.sura.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "EMPLEADOS", schema = "CONEXION")
public class Empleado {
    @Id
    @Column(name = "ID_EMPLEADO", nullable = false)
    private Long id;

    @Column(name = "NOMBRE", nullable = false, length = 20)
    private String nombre;

    @Column(name = "APELLIDO", nullable = false, length = 20)
    private String apellido;

    @Column(name = "DIRECCION", nullable = false, length = 40)
    private String direccion;

    @Column(name = "CORREO", nullable = false, length = 40)
    private String correo;

    @Column(name = "TELEFONO", nullable = false)
    private Long telefono;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

}