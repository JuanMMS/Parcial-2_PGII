package uniquindio.empresa.model;

import java.util.List;

public class SoporteTecnico extends DecoradorComplemento{

    public SoporteTecnico(String id, ServicioTecnologico servicioTecnologico) {
        super(id,servicioTecnologico);
    }


    /**
     * Metodo que suma los valores del complemento, es heredado de DecoradorComplemento
     * @return
     */
    @Override
    public double valorComplemento() {
        return servicioTecnologico.valorComplemento() + 50000;
    }

}
