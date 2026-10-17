package uniquindio.empresa.model.Factory;

import uniquindio.empresa.model.IElemento;

import java.util.ArrayList;
import java.util.List;

public class DatosServicioTecnologico {
    private String codigo;
    private String nombre;
    private String descripcion;


    /**
     * Metodo que construye los datos basicos para crear un servicio tecnologico
     * @param codigo
     * @param nombre
     * @param descripcion
     */
    public DatosServicioTecnologico(String codigo, String nombre, String descripcion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;

    }

    /**
     * Getters y setters
     * @return
     */
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
