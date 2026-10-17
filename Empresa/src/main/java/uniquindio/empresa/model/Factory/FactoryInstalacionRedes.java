package uniquindio.empresa.model.Factory;

import uniquindio.empresa.model.InstalacionRedes;
import uniquindio.empresa.model.ServicioTecnologico;

public class FactoryInstalacionRedes extends FactoryServicioTecnologico{


    /**
     * Metodo que crea un servicio de instalacion de redes con los datos recibidos
     * @param datos
     * @return servicio de instalacion de redes
     */
    @Override
    public ServicioTecnologico crearServicioTecnologico(DatosServicioTecnologico datos) {
        return new InstalacionRedes(datos.getCodigo(), datos.getNombre(), datos.getDescripcion());
    }
}
