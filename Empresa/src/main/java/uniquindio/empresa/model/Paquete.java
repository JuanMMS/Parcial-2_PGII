package uniquindio.empresa.model;

import java.util.ArrayList;
import java.util.List;

public class Paquete implements IElemento {
    private String codigo;
    private String nombre;
    private List<IElemento> listServiciosTecnologicosPaquete;


    /**
     * Metodo constructor de la clase Paquete
     * @param codigo
     * @param nombre
     */
    public Paquete(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.listServiciosTecnologicosPaquete = new ArrayList<>();

    }

    /**
     * Metodo que calcula el costo contenido dentro del Paquete
     * @return
     */
    @Override
    public double calcularCosto() {
        double costo = 0;
        for (IElemento servicio : listServiciosTecnologicosPaquete) {
            costo += servicio.calcularCosto();
            }
        return costo;
        }

    /**
     * Metodo que recupera todos los elementos que están conenidos dentro de Paquete
     * @return
     */
    @Override
    public List<IElemento> obtenerElementos() {
        List<IElemento> listaElementos = new ArrayList<>();
        for (IElemento servicio : listServiciosTecnologicosPaquete) {
            listaElementos.addAll(servicio.obtenerElementos());
        }
        return listaElementos;
    }

    /**
     *Getters y setters
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

    public List<IElemento> getListServiciosTecnologicosPaquete() {
        return listServiciosTecnologicosPaquete;
    }

    public void setListServiciosTecnologicosPaquete(List<IElemento> listServiciosTecnologicosPaquete) {
        this.listServiciosTecnologicosPaquete = listServiciosTecnologicosPaquete;
    }
}