package uniquindio.empresa.model;

public class SoporteTecnico extends DecoradorComplemento{

    public SoporteTecnico(String id, ServicioTecnologico servicioTecnologico) {
        super(id,servicioTecnologico);
    }

    @Override
    public double valorComplemento() {
        return servicioTecnologico.valorComplemento() + 50000;
    }
}
