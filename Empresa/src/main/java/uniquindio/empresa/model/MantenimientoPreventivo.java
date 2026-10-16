package uniquindio.empresa.model;

public class MantenimientoPreventivo extends ServicioTecnologico{

    public MantenimientoPreventivo(String codigo, String nombre, String descripcion, double costoBase) {
        super(codigo, nombre, descripcion);
    }

    @Override
    public double calcularCosto() {
        return 80000 + getCosto();
    }
}
