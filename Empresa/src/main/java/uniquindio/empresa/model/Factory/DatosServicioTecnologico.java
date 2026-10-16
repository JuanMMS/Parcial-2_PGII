package uniquindio.empresa.model.Factory;

public class DatosServicioTecnologico {
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
    public DatosServicioTecnologico(String codigo, String nombre, String descripcion, double costoBase) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costoBase = costoBase;

    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCostoBase() {
        return costoBase;
    }

    public void setCostoBase(double costoBase) {
        this.costoBase = costoBase;
    }
}
