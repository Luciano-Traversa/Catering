package ar.edu.unahur.obj2.catering.AdicionalesYContratos;

import ar.edu.unahur.obj2.catering.ServiciosYMenus.Oferta;

public class VallijaPremium extends Adicional {
    
    public VallijaPremium(Oferta ofertaEnvuelta) {
        super(ofertaEnvuelta);
        //TODO Auto-generated constructor stub
    }

    @Override
    public Double calcularPrecio() {
        return ofertaEnvuelta.calcularPrecio() + 12000.0; // Suma $12.000
    }

    @Override
    public String getDescripcion() {
        return ofertaEnvuelta.getDescripcion() + " + Vajilla premium";
    }
}
