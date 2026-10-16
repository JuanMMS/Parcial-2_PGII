package uniquindio.empresa.model.Factory;

import uniquindio.empresa.model.MantenimientoPreventivo;
import uniquindio.empresa.model.ServicioTecnologico;

public class FactoryMantenimientoPreventivo extends FactoryServicioTecnologico{

    @Override
    public ServicioTecnologico crearServicioTecnologico(DatosServicioTecnologico datos) {
        return new MantenimientoPreventivo(datos.getCodigo(), datos.getNombre(), datos.getDescripcion(), datos.getCostoBase());
    }
}
