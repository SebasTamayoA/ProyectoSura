package com.example.sura.model;

import jakarta.persistence.*;

@Entity
@Table(name = "PAGOS", schema = "CONEXION")
public class Pago {
    @Id
    @Column(name = "ID_PAGO", nullable = false)
    private Long id;

    @Column(name = "VALOR", nullable = false)
    private Float valor;

    @Column(name = "TIPO_PAGO", nullable = false, length = 30)
    private String tipoPago;

    @Column(name = "DETALLE", nullable = false, length = 2000)
    private String detalle;

    @Column(name = "ESTADO", nullable = false, length = 10)
    private String estado;

    @Column(name = "CODIGO_PAGO", nullable = false, length = 30)
    private String codigoPago;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_CLIENTE", nullable = false)
    private Cliente idCliente;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_POLIZA", nullable = false)
    private Poliza idPoliza;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCodigoPago() {
        return codigoPago;
    }

    public void setCodigoPago(String codigoPago) {
        this.codigoPago = codigoPago;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Poliza getIdPoliza() {
        return idPoliza;
    }

    public void setIdPoliza(Poliza idPoliza) {
        this.idPoliza = idPoliza;
    }

}