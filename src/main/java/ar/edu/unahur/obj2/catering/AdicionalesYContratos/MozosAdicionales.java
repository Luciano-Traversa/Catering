package ar.edu.unahur.obj2.catering.AdicionalesYContratos;

import ar.edu.unahur.obj2.catering.ServiciosYMenus.Oferta;

public class MozosAdicionales extends Adicional  {

    public MozosAdicionales(Oferta ofertaEnvuelta) {
        super(ofertaEnvuelta);
    }

    @Override
    public Double calcularPrecio() {
        return ofertaEnvuelta.calcularPrecio() + 18000.0; 
    }

    @Override
    public String getDescripcion() {
        return ofertaEnvuelta.getDescripcion() + " + Mozos adicionales";
    }

}
