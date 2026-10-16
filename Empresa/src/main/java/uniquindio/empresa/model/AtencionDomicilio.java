package uniquindio.empresa.model;

public class AtencionDomicilio extends DecoradorComplemento{


    /**
     * Metodo constructor de la clase AtencionDomicilio
     * @param id
     * @param servicioTecnologico
     */
    public AtencionDomicilio(String id, ServicioTecnologico servicioTecnologico) {
        super(id, servicioTecnologico);
    }


    /**
     * Metodo para sumar el complemento con el valor de AtencionDomicilio (AtencionDomicilio = 25,000 pesos)
     * @return
     */
    @Override
    public double valorComplemento() {
        return servicioTecnologico.valorComplemento() + 25000;
    }
}
