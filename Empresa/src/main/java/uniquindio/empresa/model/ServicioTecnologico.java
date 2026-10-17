package uniquindio.empresa.model;

import java.util.ArrayList;
import java.util.List;

public abstract class ServicioTecnologico implements IElemento, IComplemento {
    private String codigo;
    private String nombre;
    private String descripcion;
    private double costoBase;


    /**
     * Metodo constructor de servicio tecnologico
     * @param codigo
     * @param nombre
     * @param descripcion
     */
    public ServicioTecnologico(String codigo, String nombre, String descripcion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;

    }


    /**
     * Metodo para obtener los elementos presentes
     * @return
     */
    @Override
    public List<IElemento> obtenerElementos() {
        List<IElemento> elementos = new ArrayList<>();
        elementos.add(this);
        return elementos;
    }

    public String getCodigo() {
        return codigo;
    }
    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getCosto() {
        return costoBase;
    }

    /**
     * Metodo que predefine el valor sin complementos que es de 0
     * @return
     */
    public double valorComplemento(){
        return 0;
    }
}
