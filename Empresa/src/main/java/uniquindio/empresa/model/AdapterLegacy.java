package uniquindio.empresa.model;

public class AdapterLegacy implements IConsultaTecnico {

    /**
     * Metodo constructor de la clase AdapterLegacy
     */
    private TecnicoLegacyService tecnicoLegacyService;
    public AdapterLegacy(TecnicoLegacyService tecnicoLegacyService) {
        this.tecnicoLegacyService = tecnicoLegacyService;
    }


    /**
     * Metodo que determina el codigo de un TecnicoLegacyService
     * @param tecnicoLegacyService
     * @return
     */
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

    /**
     * Metodo que determina la disponibilidad de un TecnicoLegacyService
     * @param tecnicoLegacyService
     * @return
     */
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

    /**
     * Metodo que deterimina el valor de desplazamiento de un TecnicoLegacyService
     * @param tecnicoLegacyService
     * @return
     */
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

