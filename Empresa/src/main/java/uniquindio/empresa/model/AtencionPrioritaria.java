package uniquindio.empresa.model;

public class AtencionPrioritaria extends DecoradorComplemento{
    public AtencionPrioritaria(String id,ServicioTecnologico servicioTecnologico) {super(id,servicioTecnologico);}


    @Override
    public double valorComplemento() {
        return servicioTecnologico.valorComplemento() + 35000;
    }
}
