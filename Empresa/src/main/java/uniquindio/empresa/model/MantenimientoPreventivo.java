package uniquindio.empresa.model;

public class MantenimientoPreventivo extends ServicioTecnologico{
    /**
     * Metodo constructor de la clase MantenimientoPreventivo
     * @param codigo
     * @param nombre
     * @param descripcion
     * @param costoBase
     */
    public MantenimientoPreventivo(String codigo, String nombre, String descripcion, double costoBase) {
        super(codigo, nombre, descripcion);
    }


    /**
     * Metodo que determina que el precio de MantenimientoPreventivo es de 80,000 pesos
     * @return
     */
    @Override
    public double calcularCosto() {
        return 80000 + getCosto();
    }
}
