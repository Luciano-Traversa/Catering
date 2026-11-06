package ar.edu.unahur.obj2.catering.ServiciosYMenus;

public interface Oferta {
    Double calcularPrecio();
    Integer cantidadDeServicios();
    boolean incluye(String nombreServicio);
    String getDescripcion();
}
