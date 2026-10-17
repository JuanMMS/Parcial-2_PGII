package uniquindio.empresa.model;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PruebaParcial {

    // 1. Personalización de Servicios con Complementos (Decorator)
    @Test
    public void testValorServicioDecorador() {
        // Servicio base = Mantenimiento Correctivo ($120.000)
        ServicioTecnologico servicioBase = new MantenimientoCorrectivo("001", "Mantenimiento Correctivo", "Reparación de hardware");

        // Complemento = Atención Prioritaria ($35.000). Usamos la clase DecoradorComplemento.
        DecoradorComplemento servicioPrioritario = new AtencionPrioritaria("PRIORIDAD-1", servicioBase);

        // Al llamar calcularCosto() sobre el decorador, la clase suma automáticamente:
        // servicioTecnologico.calcularCosto() + this.valorComplemento()
        double costoTotal = servicioPrioritario.calcularCosto();

        // Salida esperada: $155.000
        assertEquals(155000.0, costoTotal, 0.01, "El costo con atención prioritaria debe ser 155.000");
    }

    // 2. Cálculo de Costo de Paquetes Tecnológicos (Composite)
    @Test
    public void testCalcularCostoPaquete() {
        // Entradas de prueba: Mantenimiento Preventivo ($80.000) y Correctivo ($120.000)
        ServicioTecnologico mantenimientoPreventivo = new MantenimientoPreventivo("002", "Mantenimiento Preventivo", "Revisión");
        ServicioTecnologico mantenimientoCorrectivo = new MantenimientoCorrectivo("003", "Mantenimiento Correctivo", "Reparación");

        // Creamos el paquete y le agregamos los elementos
        Paquete paquete = new Paquete("PAQ-01", "Paquete Integral");
        paquete.getListServiciosTecnologicosPaquete().add(mantenimientoPreventivo);
        paquete.getListServiciosTecnologicosPaquete().add(mantenimientoCorrectivo);

        // Salida esperada: $200.000
        assertEquals(200000.0, paquete.calcularCosto(), 0.01, "El costo total del paquete debe ser la suma de sus elementos (200.000)");
    }

    // 3. Consulta e Integración con Plataforma Externa (Adapter)
    @Test
    public void testConsultarAdaptadorLegacy() {
        // Entrada de prueba: Cadena Legacy y código especialidad
        TecnicoLegacyService legacyService = new TecnicoLegacyService("105", "TEC-105|DISPONIBLE|30000");

        // Adaptador recibe la instancia en el constructor
        IConsultaTecnico adaptador = new AdapterLegacy(legacyService);

        // Validación de salidas transformadas por el adaptador mediante .split("\\|")
        String codigoExtraido = adaptador.consultarCodigoTecnico(legacyService);
        boolean disponibilidadExtraida = adaptador.consultarDisponibilidad(legacyService);
        double costoDesplazamientoExtraido = adaptador.consultarValorDesplazamiento(legacyService);

        // Salidas esperadas
        assertEquals("TEC-105", codigoExtraido, "El código extraído debe ser TEC-105");
        assertTrue(disponibilidadExtraida, "La disponibilidad debe ser true (DISPONIBLE)");
        assertEquals(30000.0, costoDesplazamientoExtraido, 0.01, "El costo de desplazamiento debe ser 30.000");
    }

}