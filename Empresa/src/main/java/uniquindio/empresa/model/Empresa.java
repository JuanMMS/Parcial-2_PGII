package uniquindio.empresa.model;

import java.util.ArrayList;

public final class Empresa {
    private String id;
    private String nombre;
    private String direccion;
    private ArrayList<ServicioTecnologico> listServicioTecnologicos;
    private ArrayList<Cliente> listClientes;
    private ArrayList<SolicitudServicio> listSolicitudesServicio;
    private ArrayList<Paquete> listPaquetes;
    private FactoryServicioTecnologico theFactoryServicioTecnologico;
    private static Empresa instance;


    /**
     * Metodo constructor de empresa
     */
    public Empresa() {
        this.id = "900123";
        this.nombre = "TechSolutions";
        this.direccion = "Avenida 1, calle 2. Oficina 3";
        this.listServicioTecnologicos = new ArrayList<>();
        this.listClientes = new ArrayList<>();
        this.listSolicitudesServicio = new ArrayList<>();
        this.listPaquetes = new ArrayList<>();


    }


    /**
     * Metodo para instanciar una sola vez a empresa
     * @return
     */
    public static Empresa getInstance() {
        if (instance == null) {
            instance = new Empresa;
        }
        return instance;
    }

}
