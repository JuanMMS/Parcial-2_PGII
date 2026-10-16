package uniquindio.empresa.model;

public abstract class ServicioTecnologico implements IElemento, IComplemento {
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

    public String getCodigo() {
        return codigo;
    }
    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getCosto() {
        return costoBase;
    }

    public double valorComplemento(){
        return 0;
    }
}
