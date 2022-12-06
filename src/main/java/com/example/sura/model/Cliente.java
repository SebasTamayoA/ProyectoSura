package com.example.sura.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CLIENTES", schema = "CONEXION")
public class Cliente {
    @Id
    @Column(name = "ID_CLIENTE", nullable = false)
    private Long id;

    @Column(name = "NOMBRE", nullable = false, length = 20)
    private String nombre;

    @Column(name = "APELLIDO", nullable = false, length = 20)
    private String apellido;

    @Column(name = "CONTRASENA", nullable = false, length = 20)
    private String contrasena;

    @Column(name = "CORREO", nullable = false, length = 40)
    private String correo;

    @Column(name = "TIPO_IDENTIFICACION", length = 30)
    private String tipoIdentificacion;

    @Column(name = "NUMERO_IDENTIFICACION", nullable = false, length = 15)
    private String numeroIdentificacion;

    @Column(name = "DIRECCION", nullable = false, length = 200)
    private String direccion;

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

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}