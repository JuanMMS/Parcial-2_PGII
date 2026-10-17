package uniquindio.empresa.model;

public class MantenimientoCorrectivo extends ServicioTecnologico{

    /**
     * Metodo constructor de la clase MantenimientoCorrectivo
     *
     * @param codigo
     * @param nombre
     * @param descripcion
     */
    public MantenimientoCorrectivo(String codigo, String nombre, String descripcion) {
        super(codigo, nombre, descripcion);
    }

    /**
     * Metodo que determina que el costo de MantenimientoCorrectivo es de 120,000 pesos
     * @return
     */
    @Override
    public double calcularCosto() {
        return 120000;
    }
}
