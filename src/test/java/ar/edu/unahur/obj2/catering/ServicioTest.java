package ar.edu.unahur.obj2.catering;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.catering.ServiciosYMenus.Menu;
import ar.edu.unahur.obj2.catering.ServiciosYMenus.Servicio;
import ar.edu.unahur.obj2.catering.ServiciosYMenus.Excepciones.DescuentoInvalidoException;
import ar.edu.unahur.obj2.catering.ServiciosYMenus.Excepciones.PrecioNegativoException;

public class ServicioTest {
    

    @Test 
    void elPrecioDelMenuParrilleroConDescuentoDe10_IncluyendoServicioDeParrilla_Musica_YBebidas_EsDe342000Pesos() {
        Servicio parrilla = new Servicio("Asado Completo", 120_000);
        Servicio dj = new Servicio("DJ y sonido", 80_000);
        Servicio bebidas = new Servicio("Barra de bebidas", 180000);
        
        Menu menuParrillero = new Menu("Menú Parrillero", 10, List.of(parrilla, dj, bebidas));

        assertEquals(342_000.0, menuParrillero.calcularPrecio());
    }

    @Test
    void laCantidadDeServiciosDelMenuParrillero_EsDeTres() {
        Servicio parrillada = new Servicio("Asado Completo", 120_000);
        Servicio dj = new Servicio("DJ y sonido", 80_000);
        Servicio bebidas = new Servicio("Barra de bebidas", 180_000);
        
        Menu menuParrillero = new Menu("Menú Parrillero", 10, List.of(parrillada, dj, bebidas));

        assertEquals(3, menuParrillero.cantidadDeServicios());
    }

    @Test
    void elMenuParrillero_IncluyeAsadoCompleto() {
        Servicio parrillada = new Servicio("Asado Completo", 120_000);
        Menu menuParrillero = new Menu("Menú Parrillero", 10, List.of(parrillada));

        assertTrue(menuParrillero.incluye("Asado Completo"));
    }

    @Test
    void ElMenuParrillero_No_IncluyeDJYSonido() {
        Servicio parrillada = new Servicio("Asado Completo", 120_000);
        Menu menuParrillero = new Menu("Menú Parrillero", 10, List.of(parrillada));

        assertFalse(menuParrillero.incluye("DJ y sonido"));
    }

    @Test
    void dadoUnServicioConPrecioNegativo_alCrearlo_lanzaPrecioNegativoException() {
        assertThrows(PrecioNegativoException.class, () -> {
            new Servicio("Servicio trucho", -500);
        });
    }

    @Test
    void dadoUnMenuConDescuentoInvalido_alCrearlo_lanzaDescuentoInvalidoException() {
        Servicio parrillada = new Servicio("Parrillada completa", 120000);
        assertThrows(DescuentoInvalidoException.class, () -> {
            new Menu("Menú Inválido", 150, List.of(parrillada));
        });
    }

    

}
