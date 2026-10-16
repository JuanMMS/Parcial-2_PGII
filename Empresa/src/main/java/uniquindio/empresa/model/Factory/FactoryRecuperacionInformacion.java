package uniquindio.empresa.model.Factory;

import uniquindio.empresa.model.RecuperacionInformacion;
import uniquindio.empresa.model.ServicioTecnologico;

public class FactoryRecuperacionInformacion extends FactoryServicioTecnologico{


    /**
     * Metodo que crea un servicio de recuperacion de informacion con los datos recibidos
     * @param datos
     * @return servicio de recuperacion de informacion
     */
    @Override
    public ServicioTecnologico crearServicioTecnologico(DatosServicioTecnologico datos) {
        return new RecuperacionInformacion(datos.getCodigo(), datos.getNombre(), datos.getDescripcion(), datos.getCostoBase());
    }
}
