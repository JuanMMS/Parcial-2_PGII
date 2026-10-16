package uniquindio.empresa.model;

public class AdapterLegacy implements IConsultaTecnico{
    private TecnicoLegacyService tecnicoLegacyService;

    public AdapterLegacy(TecnicoLegacyService tecnicoLegacyService) {this.tecnicoLegacyService = tecnicoLegacyService;}

    @Override
    public void consultarCodigoTecnico() {

    }

    @Override
    public void consultarDisponibilidad() {

    }

    @Override
    public void consultarValorDesplazamiento() {

    }
}
