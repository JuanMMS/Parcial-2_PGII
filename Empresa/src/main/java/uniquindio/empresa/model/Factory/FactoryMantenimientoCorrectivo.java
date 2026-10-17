package uniquindio.empresa.model.Factory;

import uniquindio.empresa.model.MantenimientoCorrectivo;
import uniquindio.empresa.model.MantenimientoPreventivo;
import uniquindio.empresa.model.ServicioTecnologico;

public class FactoryMantenimientoCorrectivo extends FactoryServicioTecnologico{


    /**
     * Metodo que crea un servicio de mantenimiento preventivo con los datos recibidos
     * @param datos
     * @return servicio de mantenimiento preventivo
     */
    @Override
    public ServicioTecnologico crearServicioTecnologico(DatosServicioTecnologico datos) {
        return new MantenimientoCorrectivo(datos.getCodigo(), datos.getNombre(), datos.getDescripcion());
    }
}

