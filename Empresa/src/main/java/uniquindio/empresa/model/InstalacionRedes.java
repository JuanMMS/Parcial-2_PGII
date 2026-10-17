package uniquindio.empresa.model;

public class InstalacionRedes extends ServicioTecnologico{


    /**
     * Metodo constructor de la clase InstalacionRedes
     * @param codigo
     * @param nombre
     * @param descripcion
     */
    public InstalacionRedes(String codigo, String nombre, String descripcion) {
        super(codigo, nombre, descripcion);
    }


    /**
     * Metodo que determina que el costo de InstalacionRedes es de 180,000
     * @return
     */
    @Override
    public double calcularCosto() {
        return 180000 + getCosto();
    }
}
