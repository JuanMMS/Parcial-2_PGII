package uniquindio.empresa.controller;

import uniquindio.empresa.model.*;
import java.time.LocalDate;
import java.util.List;

public class SolicitudController {
    private final Empresa empresa;

    public SolicitudController() {
        this.empresa = Empresa.getInstance();
    }

    public List<Cliente> obtenerClientes() {
        return empresa.getListClientes();
    }

    public List<ServicioTecnologico> obtenerServiciosTecnologicos() {
        return empresa.getListServicioTecnologicos();
    }

    public List<Paquete> obtenerPaquetes() {
        return empresa.getListPaquetes();
    }

    // Retornamos el objeto Legacy directamente, sin DTOs y respetando el modelo
    public TecnicoLegacyService consultarTecnicoLegacy(String especialidad) {
        String datosLegacy;
        if ("105".equals(especialidad) || "REDES".equalsIgnoreCase(especialidad)) {
            datosLegacy = "TEC-105|DISPONIBLE|30000";
        } else if ("102".equals(especialidad) || "HARDWARE".equalsIgnoreCase(especialidad)) {
            datosLegacy = "TEC-102|DISPONIBLE|25000";
        } else {
            datosLegacy = "SIN_TECNICO|NO_DISPONIBLE|0";
        }

        return new TecnicoLegacyService(datosLegacy);
    }

    public boolean registrarSolicitud(String codigo, Cliente cliente, List<IElemento> elementos,
                                      LocalDate fechaProg, String observaciones, String prioridadStr,
                                      boolean requiereTecnico, boolean tecnicoDisponible) {

        if (requiereTecnico && !tecnicoDisponible) {
            throw new IllegalStateException("Atención presencial no disponible: No hay un técnico habilitado.");
        }

        int prioridad = 1;
        if (prioridadStr != null && !prioridadStr.isBlank()) {
            try {
                prioridad = Integer.parseInt(prioridadStr);
            } catch (NumberFormatException ignored) {}
        }

        SolicitudServicioBuilder solicitud = new SolicitudServicioBuilder.Builder(codigo, cliente)
                .listElementos(elementos)
                .conFechaProgramada(fechaProg)
                .conObservaciones(observaciones)
                .conNivelPrioridad(prioridad)
                .conAtencionPresencial(requiereTecnico)
                .build();

        return empresa.crearSolicitudServicio(solicitud);
    }
}