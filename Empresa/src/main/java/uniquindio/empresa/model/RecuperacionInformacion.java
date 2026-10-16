package uniquindio.empresa.model;

public class RecuperacionInformacion extends ServicioTecnologico{

    public RecuperacionInformacion(String codigo, String nombre, String descripcion, double costoBase) {
        super(codigo, nombre, descripcion);
    }

    @Override
    public double calcularCosto() {
        return 150000 + getCosto();
    }
}