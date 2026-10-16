
package uniquindio.empresa.model;

import uniquindio.empresa.model.Factory.FactoryServicioTecnologico;

import java.util.ArrayList;

public final class Empresa {
    private String id;
    private String nombre;
    private String direccion;

    private ArrayList<ServicioTecnologico> listServicioTecnologicos;
    private ArrayList<Cliente> listClientes;
    private ArrayList<SolicitudServicioBuilder> listSolicitudesServicio;
    private ArrayList<Paquete> listPaquetes;

    private FactoryServicioTecnologico theFactoryServicioTecnologico;
    private static Empresa instance;

    /**
     * Constructor privado para garantizar el patrón Singleton
     */
    private Empresa() {
        this.id = "900123";
        this.nombre = "TechSolutions";
        this.direccion = "Avenida 1, calle 2. Oficina 3";
        this.listServicioTecnologicos = new ArrayList<>();
        this.listClientes = new ArrayList<>();
        this.listSolicitudesServicio = new ArrayList<>();
        this.listPaquetes = new ArrayList<>();
    }

    /**
     * Método para obtener la instancia única de Empresa (Singleton)
     * @return Instancia única de Empresa
     */
    public static Empresa getInstance() {
        if (instance == null) {
            instance = new Empresa();
        }
        return instance;
    }

    // =========================================================================
    // 1. GESTIÓN DE CLIENTES (CRUD)
    // =========================================================================

    public boolean crearCliente(Cliente nuevoCliente) {
        if (nuevoCliente == null || buscarCliente(nuevoCliente.getDocumento()) != null) {
            return false; // Ya existe o es nulo
        }
        return listClientes.add(nuevoCliente);
    }

    public Cliente buscarCliente(String id) {
        if (id == null || id.isBlank()) return null;
        for (Cliente cliente : listClientes) {
            if (cliente.getDocumento().equalsIgnoreCase(id)) {
                return cliente;
            }
        }
        return null;
    }

    public boolean actualizarCliente(String id, Cliente clienteActualizado) {
        Cliente clienteExistente = buscarCliente(id);
        if (clienteExistente != null && clienteActualizado != null) {
            int index = listClientes.indexOf(clienteExistente);
            listClientes.set(index, clienteActualizado);
            return true;
        }
        return false;
    }

    public boolean eliminarCliente(String id) {
        Cliente cliente = buscarCliente(id);
        if (cliente != null) {
            return listClientes.remove(cliente);
        }
        return false;
    }

    // =========================================================================
    // 2. GESTIÓN DE SERVICIOS TECNOLÓGICOS (CRUD)
    // =========================================================================

    public boolean crearServicioTecnologico(ServicioTecnologico nuevoServicio) {
        if (nuevoServicio == null || buscarServicioTecnologico(nuevoServicio.getCodigo()) != null) {
            return false;
        }
        return listServicioTecnologicos.add(nuevoServicio);
    }

    public ServicioTecnologico buscarServicioTecnologico(String codigo) {
        if (codigo == null || codigo.isBlank()) return null;
        for (ServicioTecnologico servicio : listServicioTecnologicos) {
            if (servicio.getCodigo().equalsIgnoreCase(codigo)) {
                return servicio;
            }
        }
        return null;
    }

    public boolean actualizarServicioTecnologico(String codigo, ServicioTecnologico servicioActualizado) {
        ServicioTecnologico servicioExistente = buscarServicioTecnologico(codigo);
        if (servicioExistente != null && servicioActualizado != null) {
            int index = listServicioTecnologicos.indexOf(servicioExistente);
            listServicioTecnologicos.set(index, servicioActualizado);
            return true;
        }
        return false;
    }

    public boolean eliminarServicioTecnologico(String codigo) {
        ServicioTecnologico servicio = buscarServicioTecnologico(codigo);
        if (servicio != null) {
            return listServicioTecnologicos.remove(servicio);
        }
        return false;
    }

    // =========================================================================
    // 3. GESTIÓN DE PAQUETES (CRUD)
    // =========================================================================

    public boolean crearPaquete(Paquete nuevoPaquete) {
        if (nuevoPaquete == null || buscarPaquete(nuevoPaquete.getCodigo()) != null) {
            return false;
        }
        return listPaquetes.add(nuevoPaquete);
    }

    public Paquete buscarPaquete(String codigo) {
        if (codigo == null || codigo.isBlank()) return null;
        for (Paquete paquete : listPaquetes) {
            if (paquete.getCodigo().equalsIgnoreCase(codigo)) {
                return paquete;
            }
        }
        return null;
    }

    public boolean actualizarPaquete(String codigo, Paquete paqueteActualizado) {
        Paquete paqueteExistente = buscarPaquete(codigo);
        if (paqueteExistente != null && paqueteActualizado != null) {
            int index = listPaquetes.indexOf(paqueteExistente);
            listPaquetes.set(index, paqueteActualizado);
            return true;
        }
        return false;
    }

    public boolean eliminarPaquete(String codigo) {
        Paquete paquete = buscarPaquete(codigo);
        if (paquete != null) {
            return listPaquetes.remove(paquete);
        }
        return false;
    }

    // =========================================================================
    // 4. GESTIÓN DE SOLICITUDES DE SERVICIO (CRUD)
    // =========================================================================

    public boolean crearSolicitudServicio(SolicitudServicioBuilder nuevaSolicitud) {
        if (nuevaSolicitud == null || buscarSolicitudServicio(nuevaSolicitud.getCodigo()) != null) {
            return false;
        }
        return listSolicitudesServicio.add(nuevaSolicitud);
    }

    public SolicitudServicioBuilder buscarSolicitudServicio(String codigo) {
        if (codigo == null || codigo.isBlank()) return null;
        for (SolicitudServicioBuilder solicitud : listSolicitudesServicio) {
            if (solicitud.getCodigo().equalsIgnoreCase(codigo)) {
                return solicitud;
            }
        }
        return null;
    }

    public boolean actualizarSolicitudServicio(String codigo, SolicitudServicioBuilder solicitudActualizada) {
        SolicitudServicioBuilder solicitudExistente = buscarSolicitudServicio(codigo);
        if (solicitudExistente != null && solicitudActualizada != null) {
            int index = listSolicitudesServicio.indexOf(solicitudExistente);
            listSolicitudesServicio.set(index, solicitudActualizada);
            return true;
        }
        return false;
    }

    public boolean eliminarSolicitudServicio(String codigo) {
        SolicitudServicioBuilder solicitud = buscarSolicitudServicio(codigo);
        if (solicitud != null) {
            return listSolicitudesServicio.remove(solicitud);
        }
        return false;
    }

    // =========================================================================
    // GETTERS Y SETTERS ATRIBUTOS Y LISTAS
    // =========================================================================

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public ArrayList<ServicioTecnologico> getListServicioTecnologicos() {
        return listServicioTecnologicos;
    }

    public ArrayList<Cliente> getListClientes() {
        return listClientes;
    }

    public ArrayList<SolicitudServicioBuilder> getListSolicitudesServicio() {
        return listSolicitudesServicio;
    }

    public ArrayList<Paquete> getListPaquetes() {
        return listPaquetes;
    }

    public FactoryServicioTecnologico getTheFactoryServicioTecnologico() {
        return theFactoryServicioTecnologico;
    }

    public void setTheFactoryServicioTecnologico(FactoryServicioTecnologico theFactoryServicioTecnologico) {
        this.theFactoryServicioTecnologico = theFactoryServicioTecnologico;
    }
}