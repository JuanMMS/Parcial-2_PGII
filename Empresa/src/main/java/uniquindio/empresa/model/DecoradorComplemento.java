package uniquindio.empresa.model;

import java.io.Serializable;

public abstract class DecoradorComplemento implements IComplemento {
    private String id;
    protected final ServicioTecnologico servicioTecnologico;

    public DecoradorComplemento(String id, ServicioTecnologico servicioTecnologico) {
        this.servicioTecnologico = servicioTecnologico;
        this.id = id;
    }

}
