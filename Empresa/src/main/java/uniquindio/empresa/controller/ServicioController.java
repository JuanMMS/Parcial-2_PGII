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

    // Calcula el costo total instanciando los decoradores por separado
    // usando el método valorComplemento() del diagrama
    public double calcularCostoSimulado(ServicioTecnologico base, boolean prioritaria, boolean soporte, boolean domicilio) {
        if (base == null) return 0.0;

        double costoTotal = base.calcularCosto();

        if (prioritaria) {
            IComplemento comp = new AtencionPrioritaria(UUID.randomUUID().toString(), base);
            costoTotal += (comp.valorComplemento() - base.calcularCosto());
        }
        if (soporte) {
            IComplemento comp = new SoporteTecnico(UUID.randomUUID().toString(), base);
            costoTotal += (comp.valorComplemento() - base.calcularCosto());
        }
        if (domicilio) {
            IComplemento comp = new AtencionDomicilio(UUID.randomUUID().toString(), base);
            costoTotal += (comp.valorComplemento() - base.calcularCosto());
        }

        return costoTotal;
    }
}