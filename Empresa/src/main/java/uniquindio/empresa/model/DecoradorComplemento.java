package uniquindio.empresa.model;

import java.io.Serializable;

public abstract class DecoradorComplemento implements IComplemento {
    private String id;
    protected final ServicioTecnologico servicioTecnologico;

    public DecoradorComplemento(String id, ServicioTecnologico servicioTecnologico) {
        this.servicioTecnologico = servicioTecnologico;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ServicioTecnologico getServicioTecnologico() {
        return servicioTecnologico;
    }
}
