package uniquindio.empresa.model;

public class TecnicoLegacyService {
    private String datosTecnico;

    public TecnicoLegacyService(String datosTecnico) {
        this.datosTecnico = datosTecnico;
    }

    public String getDatosTecnico() {
        return datosTecnico;
    }

    public void setDatosTecnico(String datosTecnico) {
        this.datosTecnico = datosTecnico;
    }

}
