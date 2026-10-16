package uniquindio.empresa.model;

public class AdapterLegacy implements IConsultaTecnico {
    private TecnicoLegacyService tecnicoLegacyService;
    public AdapterLegacy(TecnicoLegacyService tecnicoLegacyService) {
        this.tecnicoLegacyService = tecnicoLegacyService;
    }


    @Override
    public String consultarCodigoTecnico(TecnicoLegacyService tecnicoLegacyService) {
        String sinTraducir = tecnicoLegacyService.getDatosTecnico();
        if (sinTraducir == null || sinTraducir.isBlank()){
            return "SIN_CODIGO";
        }
        String[] partes = sinTraducir.split("\\|");
        if(partes.length > 0){
            return partes[0].trim();
        }
        return "SIN_CODIGO";
    }

    @Override
    public boolean consultarDisponibilidad(TecnicoLegacyService tecnicoLegacyService) {
        String sinTraducir = tecnicoLegacyService.getDatosTecnico();
        if(sinTraducir == null || sinTraducir.isBlank()){
            return false;
        }
        String[] partes = sinTraducir.split("\\|");
        if(partes.length > 1){
            return "DISPONIBLE".equals(partes[1].trim()); //OJO con esto
        }
        return false;
    }

    @Override
    public double consultarValorDesplazamiento(TecnicoLegacyService tecnicoLegacyService) {
        String sinTraducir = tecnicoLegacyService.getDatosTecnico();
        if(sinTraducir == null || sinTraducir.isBlank()){
            return 0;
        }
        String[] partes = sinTraducir.split("\\|");
        if(partes.length > 3){
            try{
                return Double.parseDouble(partes[2]);
            } catch (NumberFormatException e){
                return 0;
            }
        }
        return 0;
    }
}

