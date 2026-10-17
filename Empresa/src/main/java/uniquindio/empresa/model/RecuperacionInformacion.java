package uniquindio.empresa.model;

public class RecuperacionInformacion extends ServicioTecnologico{

    /**
     * Metodo constructor de la clase RecuperacionInformacion
     *
     * @param codigo
     * @param nombre
     * @param descripcion
     */
    public RecuperacionInformacion(String codigo, String nombre, String descripcion) {
        super(codigo, nombre, descripcion);
    }

    /**
     * Metodo que configura el costo de RecuperacionInformacion en 150,000 pesos
     * @return
     */
    @Override
    public double calcularCosto() {
        return 150000;
    }
}