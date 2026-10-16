package uniquindio.empresa.model;

public class InstalacionRedes extends ServicioTecnologico{

    public InstalacionRedes(String codigo, String nombre, String descripcion, double costoBase) {
        super(codigo, nombre, descripcion);
    }


    @Override
    public double calcularCosto() {
        return 180000 + getCosto();
    }
}
