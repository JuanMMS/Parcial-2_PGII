package uniquindio.empresa.model;

public interface IConsultaTecnico {
    String consultarCodigoTecnico(String especialidad);
    boolean consultarDisponibilidad(String especialidad);
    double consultarValorDesplazamiento(String especialidad);
}