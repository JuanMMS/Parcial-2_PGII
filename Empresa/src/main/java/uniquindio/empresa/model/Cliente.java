package uniquindio.empresa.model;

import java.util.ArrayList;

public class Cliente {
    private String doucmento;
    private String nombreCompleto;
    private String correoElectronico;
    private ArrayList<SolicitudServicio> listSolicitudesServicioCliente;

    public Cliente(String documento, String nombreCompleto, String correoElectronico){
        this.doucmento = documento;
        this.nombreCompleto = nombreCompleto;
        this.correoElectronico = correoElectronico;
        this.listSolicitudesServicioCliente = new ArrayList<>();
    }
}
