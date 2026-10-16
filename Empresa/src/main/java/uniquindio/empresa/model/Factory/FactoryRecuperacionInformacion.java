package uniquindio.empresa.model.Factory;

import uniquindio.empresa.model.RecuperacionInformacion;
import uniquindio.empresa.model.ServicioTecnologico;

public class FactoryRecuperacionInformacion extends FactoryServicioTecnologico{

    @Override
    public ServicioTecnologico crearServicioTecnologico(DatosServicioTecnologico datos) {
        return new RecuperacionInformacion(datos.getCodigo(), datos.getNombre(), datos.getDescripcion(), datos.getCostoBase());
    }
}
