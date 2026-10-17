package uniquindio.empresa.model;

import java.util.List;

public class AtencionPrioritaria extends DecoradorComplemento{

    /**
     * Metodo constructor de la clase AtencionPrioritaria
     * @param id
     * @param servicioTecnologico
     */
    public AtencionPrioritaria(String id,ServicioTecnologico servicioTecnologico) {super(id,servicioTecnologico);}


    /**
     * Metodo para sumar que el precio de AtencionPrioritaria al valor complemento (AtencionPrioritaria = 35,000 pesos)
     * @return
     */
    @Override
    public double valorComplemento() {
        return servicioTecnologico.valorComplemento() + 35000;
    }
    
}
