package ar.edu.unahur.obj2.catering.AdicionalesYContratos;

import ar.edu.unahur.obj2.catering.ServiciosYMenus.Oferta;

public class Contrato {
    private final String cliente;
    private final Double importeFijo;
    private final String descripcionFija;

    public Contrato(String cliente, Oferta propuesta) {
        this.cliente = cliente;
        this.importeFijo = propuesta.calcularPrecio();
        this.descripcionFija = propuesta.getDescripcion();
    }

    public Double getImporte() {
        return importeFijo;
    }

    public String getDescripcion() {
        return descripcionFija;
    }

    public String getCliente() {
        return cliente;
    }
}
