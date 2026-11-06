package ar.edu.unahur.obj2.catering.AdicionalesYContratos;

import ar.edu.unahur.obj2.catering.ServiciosYMenus.Oferta;

public abstract class Adicional implements Oferta {
    
    protected final Oferta ofertaEnvuelta;

    public Adicional(Oferta ofertaEnvuelta) {
        this.ofertaEnvuelta = ofertaEnvuelta;
    }

    @Override
    public Double calcularPrecio() {
        return ofertaEnvuelta.calcularPrecio();
    }

    @Override
    public Integer cantidadDeServicios() {
        return ofertaEnvuelta.cantidadDeServicios();
    }

    @Override
    public boolean incluye(String nombreServicio) {
        return ofertaEnvuelta.incluye(nombreServicio);
    }

    
    @Override
    public String getDescripcion() {
        return ofertaEnvuelta.getDescripcion();
    }
}

