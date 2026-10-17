package uniquindio.empresa.controller;

import uniquindio.empresa.model.*;
import java.util.List;
import java.util.UUID;

public class ServicioController {
    private final Empresa empresa;

    public ServicioController() {
        this.empresa = Empresa.getInstance();
    }

    public List<ServicioTecnologico> obtenerServiciosTecnologicos() {
        return empresa.getListServicioTecnologicos();
    }

    // Calcula el costo total sumando directamente el valor de cada complemento
    public double calcularCostoSimulado(ServicioTecnologico base, boolean prioritaria, boolean soporte, boolean domicilio) {
        if (base == null) return 0.0;

        // Iniciamos con el costo del servicio base
        double costoTotal = base.calcularCosto();

        // Sumamos solo el extra de cada decorador seleccionado
        if (prioritaria) {
            IComplemento comp = new AtencionPrioritaria(UUID.randomUUID().toString(), base);
            costoTotal += comp.valorComplemento();
        }
        if (soporte) {
            IComplemento comp = new SoporteTecnico(UUID.randomUUID().toString(), base);
            costoTotal += comp.valorComplemento();
        }
        if (domicilio) {
            IComplemento comp = new AtencionDomicilio(UUID.randomUUID().toString(), base);
            costoTotal += comp.valorComplemento();
        }

        return costoTotal;
    }
}