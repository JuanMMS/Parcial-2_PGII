package uniquindio.empresa.model;

import java.util.ArrayList;
import java.util.List;

public class Paquete implements IElemento {
    private String codigo;
    private String nombre;
    private List<IElemento> listServiciosTecnologicosPaquete;


    public Paquete(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.listServiciosTecnologicosPaquete = new ArrayList<>();

    }


    @Override
    public String getCodigo() {
        return codigo;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String getDescripcion() {
        return "";
    }

    @Override
    public double getCosto() {
        return 0;
    }


    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<IElemento> getListServiciosTecnologicosPaquete() {
        return listServiciosTecnologicosPaquete;
    }

    public void setListServiciosTecnologicosPaquete(List<IElemento> listServiciosTecnologicosPaquete) {
        this.listServiciosTecnologicosPaquete = listServiciosTecnologicosPaquete;
    }
}


