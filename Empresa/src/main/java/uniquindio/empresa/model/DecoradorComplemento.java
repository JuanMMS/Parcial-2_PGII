package uniquindio.empresa.model;

import java.io.Serializable;

public abstract class DecoradorComplemento implements IComplemento, IElemento {
    private String id;
    protected final ServicioTecnologico servicioTecnologico;

    /**>
     * Metodo constructor de la clase DecoradorComplemento
     * @param id
     * @param servicioTecnologico
     */
    public DecoradorComplemento(String id, ServicioTecnologico servicioTecnologico) {
        this.servicioTecnologico = servicioTecnologico;
        this.id = id;
    }


    /**
     * Getters y setters
     * @return
     */
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
