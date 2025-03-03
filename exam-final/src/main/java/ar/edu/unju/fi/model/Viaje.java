package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import lombok.Data;
@Component
@Data
public class Viaje {

    private int id;
    private String tipo; // "corta", "media", "larga"private TipoViaje tipo
    private double costo; // Costo base del viaje

    //por ahora lo calculamos aqui luego lo podemos calcular en la base de datos
    public static double obtenerCostoBase(String tipo) {
        switch (tipo.toLowerCase()) {
            case "corta":
                return 7000;
            case "media":
                return 10000;
            case "larga":
                return 20000;
            default:
                throw new IllegalArgumentException("Tipo de viaje no válido: ");
        }
        }
}
