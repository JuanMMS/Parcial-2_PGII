package uniquindio.empresa.model;

public class MantenimientoCorrectivo extends ServicioTecnologico{
    public MantenimientoCorrectivo(String codigo, String nombre, String descripcion, double costoBase) {
        super(codigo, nombre, descripcion);
    }

    @Override
    public double calcularCosto() {
        return 120000 + getCosto();
    }
}
