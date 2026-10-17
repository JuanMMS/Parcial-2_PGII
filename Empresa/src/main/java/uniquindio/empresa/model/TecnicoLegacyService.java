package uniquindio.empresa.model;

public class TecnicoLegacyService {
    private String codigoEspecialidad;
    private String datosTecnico;


    /**
     * Metoodo constructor de la clase TecnicoLegacyService
     * @param datosTecnico
     */
    public TecnicoLegacyService(String codigoEspecialidad, String datosTecnico) {
        this.codigoEspecialidad = codigoEspecialidad;
        this.datosTecnico = datosTecnico;

    }

    public String getDatosTecnico() {
        return datosTecnico;
    }

    public void setDatosTecnico(String datosTecnico) {
        this.datosTecnico = datosTecnico;
    }

}
