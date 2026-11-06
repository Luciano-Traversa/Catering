package ar.edu.unahur.obj2.catering.ServiciosYMenus;

import ar.edu.unahur.obj2.catering.ServiciosYMenus.Excepciones.PrecioNegativoException;

public class Servicio implements Oferta {
    private final String nombre;
    private final Integer precio;

    public Servicio(String nombre, Integer precio) {

        if (precio < 0) {
            throw new PrecioNegativoException("El precio no puede ser negativo");
        }

        this.nombre = nombre;
        this.precio = precio;
    }

    @Override 
    public String getDescripcion() {
        return nombre;
    }

    public Integer getPrecio() {
        return precio;
    }

    @Override
    public Double calcularPrecio() {
        return precio.doubleValue();
    }

    @Override
    public Integer cantidadDeServicios() {
       return 1;
    }

    @Override
    public boolean incluye(String nombreServicio) {
        return this.nombre.equals(nombreServicio);
    }
}
