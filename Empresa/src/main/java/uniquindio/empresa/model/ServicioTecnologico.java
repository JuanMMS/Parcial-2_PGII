package uniquindio.empresa.model;

public abstract class ServicioTecnologico implements IServicio{
    private String codigo;
    private String nombre;
    private String descripcion;
    private double costoBase;


    /**
     * Metodo constructor de servicio tecnologico
     * @param codigo
     * @param nombre
     * @param descripcion
     * @param costoBase
     */
    public ServicioTecnologico(String codigo, String nombre, String descripcion, double costoBase) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costoBase = costoBase;

    }
    @Override
    public String getCodigo() {
        return codigo;
    }
    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public double getCosto() {
        return costoBase;
    }
}
