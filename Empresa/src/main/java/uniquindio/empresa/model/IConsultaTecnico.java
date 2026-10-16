package uniquindio.empresa.model;

public interface IConsultaTecnico {

    /**
     * Metodo para que retorne el codigo que hay contenido dentro de un objeto de tipo TecnicoLegacyService
     * @param tecnicoLegacyService
     * @return
     */
    String consultarCodigoTecnico(TecnicoLegacyService tecnicoLegacyService);

    /**
     * Metodo para que retorne la disponibilidad que hay contenido dentro de un objeto de tipo TecnicoLegacyService
     * @param tecnicoLegacyService
     * @return
     */
    boolean consultarDisponibilidad(TecnicoLegacyService tecnicoLegacyService);

    /**
     * Metodo para que retorne el valor del desplazamiento de un tecnico que hay contenido dentro de un objeto de tipo TecnicoLegacyService
     * @param tecnicoLegacyService
     * @return
     */
    double consultarValorDesplazamiento(TecnicoLegacyService tecnicoLegacyService);
}