package uniquindio.empresa.model;

public interface IConsultaTecnico {
    String consultarCodigoTecnico(TecnicoLegacyService tecnicoLegacyService);
    boolean consultarDisponibilidad(TecnicoLegacyService tecnicoLegacyService);
    double consultarValorDesplazamiento(TecnicoLegacyService tecnicoLegacyService);
}