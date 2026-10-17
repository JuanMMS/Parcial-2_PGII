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

    public ServicioTecnologico construirServicioPersonalizado(ServicioTecnologico base, boolean prioritaria, boolean soporte, boolean domicilio) {
        if (base == null) return null;
        ServicioTecnologico resultado = base;
        if (prioritaria) {
            resultado = new AtencionPrioritaria(UUID.randomUUID().toString(), resultado);
        }
        if (soporte) {
            resultado = new SoporteTecnico(UUID.randomUUID().toString(), resultado);
        }
        if (domicilio) {
            resultado = new AtencionDomicilio(UUID.randomUUID().toString(), resultado);
        }
        return resultado;
    }

    public boolean guardarServicioPersonalizado(ServicioTecnologico base, boolean prioritaria, boolean soporte, boolean domicilio) {
        ServicioTecnologico personalizado = construirServicioPersonalizado(base, prioritaria, soporte, domicilio);
        if (personalizado == null) return false;
        return empresa.crearServicioTecnologico(personalizado);
    }
}