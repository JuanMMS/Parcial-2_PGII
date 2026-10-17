package uniquindio.empresa.model;

public class TecnicoLegacyService {
    private String codigoEspecialidad;
    private String datosTecnico;

    /**
     * Metodo constructor de la clase Tecnico legacy Service
     * @param codigoEspecialidad
     * @param datosTecnico
     */
    public TecnicoLegacyService(String codigoEspecialidad, String datosTecnico) {
        this.codigoEspecialidad = codigoEspecialidad;
        this.datosTecnico = datosTecnico;
    }

    // Nuevo Getter
    public String getCodigoEspecialidad() {
        return codigoEspecialidad;
    }

    public void setCodigoEspecialidad(String codigoEspecialidad) {
        this.codigoEspecialidad = codigoEspecialidad;
    }

    public String getDatosTecnico() {
        return datosTecnico;
    }

    public void setDatosTecnico(String datosTecnico) {
        this.datosTecnico = datosTecnico;
    }
}