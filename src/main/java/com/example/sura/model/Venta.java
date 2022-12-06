package com.example.sura.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "VENTAS", schema = "CONEXION")
public class Venta {
    @Id
    @Column(name = "ID_VENTA", nullable = false)
    private Long id;

    @Column(name = "FECHA_VENTA", nullable = false)
    private LocalDate fechaVenta;

    @Column(name = "CODIGO_PAGO", nullable = false, length = 15)
    private String codigoPago;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_POLIZA", nullable = false)
    private Poliza idPoliza;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_CLIENTE_EMPLEADO", nullable = false)
    private ClienteEmpleado idClienteEmpleado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDate fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public String getCodigoPago() {
        return codigoPago;
    }

    public void setCodigoPago(String codigoPago) {
        this.codigoPago = codigoPago;
    }

    public Poliza getIdPoliza() {
        return idPoliza;
    }

    public void setIdPoliza(Poliza idPoliza) {
        this.idPoliza = idPoliza;
    }

    public ClienteEmpleado getIdClienteEmpleado() {
        return idClienteEmpleado;
    }

    public void setIdClienteEmpleado(ClienteEmpleado idClienteEmpleado) {
        this.idClienteEmpleado = idClienteEmpleado;
    }

}