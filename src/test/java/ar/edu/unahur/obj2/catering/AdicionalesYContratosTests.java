package ar.edu.unahur.obj2.catering;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.catering.AdicionalesYContratos.Contrato;
import ar.edu.unahur.obj2.catering.AdicionalesYContratos.MozosAdicionales;
import ar.edu.unahur.obj2.catering.AdicionalesYContratos.ServicioNocturno;
import ar.edu.unahur.obj2.catering.ServiciosYMenus.Menu;
import ar.edu.unahur.obj2.catering.ServiciosYMenus.Oferta;
import ar.edu.unahur.obj2.catering.ServiciosYMenus.Servicio;

public class AdicionalesYContratosTests {
    @Test
    void dadoUnMenuParrillero_alAgregarMozosAdicionales_calculaPrecioCorrectamente() {
        Servicio parrillada = new Servicio("Parrillada completa", 120_000);
        Servicio dj = new Servicio("DJ y sonido", 80_000);
        Servicio bebidas = new Servicio("Barra de bebidas", 180_000);
        Oferta menuParrillero = new Menu("Menú Parrillero", 10, List.of(parrillada, dj, bebidas));
        
        Oferta menuConMozos = new MozosAdicionales(menuParrillero);
        
        assertEquals(360_000.0, menuConMozos.calcularPrecio());
    }


    @Test
    void dadoUnMenuParrillero_alAplicarMozosAntesQueNocturno_elOrdenAlteraElPrecioFinal() {
        Servicio parrillada = new Servicio("Parrillada completa", 120_000);
        Servicio dj = new Servicio("DJ y sonido", 80_000);
        Servicio bebidas = new Servicio("Barra de bebidas", 180_000);
        Oferta menuParrillero = new Menu("Menú Parrillero", 10, List.of(parrillada, dj, bebidas));
        
        Oferta conNocturno = new ServicioNocturno(menuParrillero);
        Oferta conMozosYNocturno = new MozosAdicionales(conNocturno);
        
        assertEquals(428_400.0, conMozosYNocturno.calcularPrecio());
    }

    
    @Test
    void dadoUnContratoCreado_alConsultarSuImporte_retornaElValorFijadoEnElMomento() {
        Servicio parrillada = new Servicio("Parrillada completa", 120_000);
        Servicio dj = new Servicio("DJ y sonido", 80_000);
        Servicio bebidas = new Servicio("Barra de bebidas", 180_000);
        Oferta menuParrillero = new Menu("Menú Parrillero", 10, List.of(parrillada, dj, bebidas));
        
        Oferta menuConMozos = new MozosAdicionales(menuParrillero);
        Contrato contrato = new Contrato("Lucía", menuConMozos);
        assertEquals(360_000.0, contrato.getImporte());
    }

    @Test
    void dadoUnContratoCreado_alModificarLaPropuestaOriginal_elImporteContratadoNoCambia() {
        Servicio parrillada = new Servicio("Parrillada completa", 120000);
        Servicio dj = new Servicio("DJ y sonido", 80000);
        Menu menuParrillero = new Menu("Menú Parrillero", 10, List.of(parrillada, dj));

        Contrato contrato = new Contrato("Carlos", menuParrillero);
        
        assertEquals(180000.0, contrato.getImporte());
        assertEquals("Carlos", contrato.getCliente());
    }

}
