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
    public double calcularCosto() {
        double costo = 0;
        for (IElemento servicio : listServiciosTecnologicosPaquete) {
            costo += servicio.calcularCosto();
            }
        return costo;
        }

    @Override
    public List<IElemento> obtenerElementos() {
        List<IElemento> listaElementos = new ArrayList<>();
        for (IElemento servicio : listServiciosTecnologicosPaquete) {
            listaElementos.addAll(servicio.obtenerElementos());
        }
        return listaElementos;
    }

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

    public List<IElemento> getListServiciosTecnologicosPaquete() {
        return listServiciosTecnologicosPaquete;
    }

    public void setListServiciosTecnologicosPaquete(List<IElemento> listServiciosTecnologicosPaquete) {
        this.listServiciosTecnologicosPaquete = listServiciosTecnologicosPaquete;
    }
}