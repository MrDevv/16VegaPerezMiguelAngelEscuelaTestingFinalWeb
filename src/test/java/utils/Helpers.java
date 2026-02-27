package utils;

import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;

public class Helpers {

    public static List<String> obtenerNombresProductos(List<WebElementFacade> productos){
        return productos.stream().map((producto) -> {
            return producto.getText();
        }).toList();
    }

    public static List<Double> obtenerPreciosProductos(List<WebElementFacade> productos){
        return productos.stream().map((producto) -> {
            String precio = producto.getText();
            precio = precio.replace("$", "");
            return Double.parseDouble(precio);
        }).toList();
    }

}
