package ar.edu.unahur.obj2.catering.ServiciosYMenus;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.catering.ServiciosYMenus.Excepciones.DescuentoInvalidoException;

public class Menu implements Oferta {
    private final String nombre;
    private final Integer descuento;
    private List<Oferta> elementos = new ArrayList<>();

    public Menu(String nombre, Integer descuento, List<Oferta> elementos) {
        if (descuento < 0 || descuento > 100) {
            throw new DescuentoInvalidoException("El descuento debe ser mayor a 0 o menor a 100");
        }

        this.nombre = nombre;
        this.descuento = descuento;
        this.elementos = elementos;
    }

    @Override 
    public String getDescripcion() {
        return nombre;
    }

    public Integer getDescuento() {
        return descuento;
    }

    @Override 
    public Integer cantidadDeServicios(){
        Integer total = 0;
        for (Oferta elemento : elementos) {
            total += elemento.cantidadDeServicios();
        }
        return total;
    }

    @Override 
    public Double calcularPrecio(){
        double sumaPrecios = 0.0;
        for (Oferta elemento : elementos) { 
        sumaPrecios += elemento.calcularPrecio(); 
        }
        return sumaPrecios - (sumaPrecios * descuento / 100.0);
        
    }

    public boolean incluye(String nombreServicio) {
        return this.elementos.stream().anyMatch(e -> e.getDescripcion().equals(nombreServicio));
    }

    
}
