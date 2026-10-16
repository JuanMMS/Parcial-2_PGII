package uniquindio.empresa.model.Factory;

import uniquindio.empresa.model.ServicioTecnologico;

public abstract class FactoryServicioTecnologico {

    /**
     * Factory Method encargado de crear un servicio tecnologico
     * @param datos
     * @return servicio tecnologico creado
     */
    public abstract ServicioTecnologico crearServicioTecnologico(DatosServicioTecnologico datos);
}
