
package uniquindio.empresa.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SolicitudServicioBuilder {

    // Atributos obligatorios
    private String codigo;
    private LocalDate fechaCreacion;
    private double costoTotal;
    private Cliente cliente;
    private List<IElemento> listElementos; // Polimorfismo: acepta servicios, paquetes y decoradores

    // Atributos opcionales
    private LocalDate fechaProgramada;
    private String observaciones;
    private int nivelPrioridad;
    private boolean atencionPresencial;

    /**
     * Constructor privado invocado únicamente por la clase Builder
     */
    private SolicitudServicioBuilder(Builder builder) {
        this.codigo = builder.codigo;
        this.fechaCreacion = builder.fechaCreacion;
        this.cliente = builder.cliente;
        this.listElementos = builder.listElementos;
        this.fechaProgramada = builder.fechaProgramada;
        this.observaciones = builder.observaciones;
        this.nivelPrioridad = builder.nivelPrioridad;
        this.atencionPresencial = builder.atencionPresencial;
        this.costoTotal = calcularCostoTotal();
    }

    /**
     * Metodo que revisa y calcula el costo total sumando todos los elementos contratados
     */
    public double calcularCostoTotal() {
        double total = 0.0;
        if (listElementos != null) {
            for (IElemento elemento : listElementos) {
                total += elemento.calcularCosto();
            }
        }
        return total;
    }

    // ==================== GETTERS Y SETTERS ====================

    public String getCodigo() {
        return codigo;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<IElemento> getListElementos() {
        return listElementos;
    }

    public LocalDate getFechaProgramada() {
        return fechaProgramada;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public int getNivelPrioridad() {
        return nivelPrioridad;
    }

    public boolean getAtencionPresencial() {
        return atencionPresencial;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setListElementos(List<IElemento> listElementos) {
        this.listElementos = listElementos;
    }

    public void setFechaProgramada(LocalDate fechaProgramada) {
        this.fechaProgramada = fechaProgramada;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public void setNivelPrioridad(int nivelPrioridad) {
        this.nivelPrioridad = nivelPrioridad;
    }

    public boolean isAtencionPresencial() {
        return atencionPresencial;
    }

    public void setAtencionPresencial(boolean atencionPresencial) {
        this.atencionPresencial = atencionPresencial;
    }

    // ==================== PATRÓN BUILDER (CLASE ESTÁTICA ANIDADA) ====================

    public static class Builder {

        // Atributos obligatorios
        private String codigo;
        private LocalDate fechaCreacion;
        private Cliente cliente;
        private List<IElemento> listElementos;

        // Atributos opcionales con valores por defecto
        private LocalDate fechaProgramada;
        private String observaciones;
        private int nivelPrioridad = 1;
        private boolean atencionPresencial = false;

        /**
         * Constructor del Builder exigiendo los parámetros OBLIGATORIOS
         */
        public Builder(String codigo, Cliente cliente) {
            this.codigo = codigo;
            this.fechaCreacion = LocalDate.now();
            this.cliente = cliente;
            this.listElementos = new ArrayList<>();
        }

        public Builder listElementos(List<IElemento> listElementos) {
            if (listElementos != null) {
                this.listElementos = listElementos;
            }
            return this;
        }

        public Builder agregarElemento(IElemento elemento) {
            if (elemento != null) {
                this.listElementos.add(elemento);
            }
            return this;
        }

        public Builder conFechaProgramada(LocalDate fechaProgramada) {
            this.fechaProgramada = fechaProgramada;
            return this;
        }

        public Builder conObservaciones(String observaciones) {
            this.observaciones = observaciones;
            return this;
        }

        public Builder conNivelPrioridad(int nivelPrioridad) {
            this.nivelPrioridad = nivelPrioridad;
            return this;
        }

        public Builder conAtencionPresencial(boolean atencionPresencial) {
            this.atencionPresencial = atencionPresencial;
            return this;
        }

        /**
         * Metodo que Construye y valida la instancia final de SolicitudServicio
         */
        public SolicitudServicioBuilder build() {
            if (codigo == null || codigo.isBlank()) {
                throw new IllegalStateException("El código de la solicitud es obligatorio.");
            }
            if (cliente == null) {
                throw new IllegalStateException("Debe asociar un cliente a la solicitud.");
            }
            return new SolicitudServicioBuilder(this);
        }
    }
}
