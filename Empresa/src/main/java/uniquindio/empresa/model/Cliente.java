package uniquindio.empresa.model;

import java.util.ArrayList;

public class Cliente {
    private String doucmento;
    private String nombreCompleto;
    private String correoElectronico;
    private ArrayList<SolicitudServicioBuilder> listSolicitudesServicioCliente;


    /**
     * Metodo constructor de la clase Cliente
     * @param documento
     * @param nombreCompleto
     * @param correoElectronico
     */
    public Cliente(String documento, String nombreCompleto, String correoElectronico){
        this.doucmento = documento;
        this.nombreCompleto = nombreCompleto;
        this.correoElectronico = correoElectronico;
        this.listSolicitudesServicioCliente = new ArrayList<>();
    }

    /**
     * Getters y Setters
     */

    public String getDocumento() {
        return doucmento;
    }

    public void setDocumento(String documento) {
        this.doucmento = doucmento;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public ArrayList<SolicitudServicioBuilder> getListSolicitudesServicioCliente() {
        return listSolicitudesServicioCliente;
    }

    public void setListSolicitudesServicioCliente(ArrayList<SolicitudServicioBuilder> listSolicitudesServicioCliente) {
        this.listSolicitudesServicioCliente = listSolicitudesServicioCliente;
    }
}
