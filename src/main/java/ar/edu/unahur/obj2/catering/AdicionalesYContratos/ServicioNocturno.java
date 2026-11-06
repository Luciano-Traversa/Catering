package ar.edu.unahur.obj2.catering.AdicionalesYContratos;

import ar.edu.unahur.obj2.catering.ServiciosYMenus.Oferta;

public class ServicioNocturno extends Adicional {
    public ServicioNocturno(Oferta ofertaEnvuelta) {
        super(ofertaEnvuelta);
    }

    @Override
    public Double calcularPrecio() {
        // Aplica el 20% sobre lo que vale la oferta hasta ese momento
        return ofertaEnvuelta.calcularPrecio() * 1.20; 
    }

    @Override
    public String getDescripcion() {
        return ofertaEnvuelta.getDescripcion() + " + Servicio nocturno";
    }
}
