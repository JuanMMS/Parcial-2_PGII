package uniquindio.empresa.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SolicitudServicio {


     //atributos obligatorios de la clase
    private String codigo;
    private LocalDate fechaCreacion;
    private double costoTotal;
    private Cliente cliente;
    private List<Paquete> listPaquetesSolicitudServicio;

    //Atributos opcionales
    private LocalDate fechaProgramada;
    private String observaciones;
    private int nivelPrioridad = 1; //Valor por defecto
    private boolean atencionPresencial = false;


    /**
     * Metodo constructor con los atributos OBLIGATORIOS para crear la clase
     * @param codigo
     * @param cliente
     */
    public SolicitudServicio(String codigo, Cliente cliente) {
        this.codigo = codigo;
        this.fechaCreacion = LocalDate.now();
        this.cliente = cliente;
        this.costoTotal = 0.0;
        this.listPaquetesSolicitudServicio = new ArrayList<Paquete>();
    }


    public SolicitudServicio conFechaProgramada(LocalDate fechaProgramada) {
        this.fechaProgramada = fechaProgramada;
        return this;
    }
    public SolicitudServicio conObservaciones(String observaciones) {
        this.observaciones = observaciones;
        return this;
    }
    public SolicitudServicio conNivelPrioridad(int nivelPrioridad) {
        this.nivelPrioridad = nivelPrioridad;
        return this;
    }
    public SolicitudServicio conAtencionPresencial(boolean atencionPresencial) {
        this.atencionPresencial = atencionPresencial;
        return this;
    }


    public SolicitudServicio build() {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalStateException("El código de la solicitud es obligatorio.");
        } if (cliente == null) {
            throw new IllegalStateException("Debe asociar un cliente a la solicitud.");
        }
        return new SolicitudServicio(this);
    }
}
