package uniquindio.empresa.controller;

import uniquindio.empresa.model.*;
import java.util.List;

public class PaqueteController {
    private final Empresa empresa;

    public PaqueteController() {
        this.empresa = Empresa.getInstance();
    }

    public List<ServicioTecnologico> obtenerServiciosTecnologicos() {
        return empresa.getListServicioTecnologicos();
    }

    public List<Paquete> obtenerPaquetes() {
        return empresa.getListPaquetes();
    }

    public boolean crearPaquete(String codigo, String nombre, List<IElemento> elementos) {
        if (codigo == null || codigo.isBlank() || nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El código y nombre del paquete son obligatorios.");
        }
        if (elementos == null || elementos.isEmpty()) {
            throw new IllegalArgumentException("Debe agregar al menos un elemento al paquete.");
        }

        Paquete paquete = new Paquete(codigo, nombre);
        for (IElemento elem : elementos) {
            if (elem == paquete || (elem instanceof Paquete p && p.getCodigo().equalsIgnoreCase(codigo))) {
                throw new IllegalArgumentException("Validación Composite: Un paquete no se puede contener a sí mismo.");
            }
            paquete.getListServiciosTecnologicosPaquete().add(elem);
        }
        return empresa.crearPaquete(paquete);
    }
}