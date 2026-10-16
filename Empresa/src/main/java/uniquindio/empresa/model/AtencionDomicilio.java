package uniquindio.empresa.model;

public class AtencionDomicilio extends DecoradorComplemento{
    public AtencionDomicilio(String id, ServicioTecnologico servicioTecnologico) {
        super(id, servicioTecnologico);
    }

    @Override
    public double valorComplemento() {
        return servicioTecnologico.valorComplemento() + 25000;
    }
}
