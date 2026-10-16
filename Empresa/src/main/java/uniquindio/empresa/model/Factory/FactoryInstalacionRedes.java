package uniquindio.empresa.model.Factory;

import uniquindio.empresa.model.InstalacionRedes;
import uniquindio.empresa.model.ServicioTecnologico;

public class FactoryInstalacionRedes extends FactoryServicioTecnologico{

    @Override
    public ServicioTecnologico crearServicioTecnologico(DatosServicioTecnologico datos) {
        return new InstalacionRedes(datos.getCodigo(), datos.getNombre(), datos.getDescripcion(), datos.getCostoBase());
    }
}
