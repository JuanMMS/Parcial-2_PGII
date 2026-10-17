package uniquindio.empresa.model;

import java.io.Serializable;
import java.util.List;

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
     * Metodo que delega la obtención de elementos al servicio original
     */
    @Override
    public double calcularCosto() {
        return servicioTecnologico.calcularCosto() + this.valorComplemento();
    }
    /**
     * Metodo que el decorador también debe delegar para sumarle su propio valor.
     */
    @Override
    public List<IElemento> obtenerElementos() {
        return servicioTecnologico.obtenerElementos();
    }


    public abstract double valorComplemento();
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
