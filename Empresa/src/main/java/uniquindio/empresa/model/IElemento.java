package uniquindio.empresa.model;

import java.util.List;

public interface IElemento {

    /**
     * Metodo para calcular costo del elemento
     * @return
     */
    public double calcularCosto();

    /**
     * Metodo para obtener los elementos
     * @return
     */
    public List<IElemento> obtenerElementos();


}
