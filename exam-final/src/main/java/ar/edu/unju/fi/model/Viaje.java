package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
//import jakarta.validation.constraints.NotNull;
import lombok.Data;
@Component
@Data
@Entity
public class Viaje {
	
	@Id
	//@NotNull(message = "El ID del viaje no puede ser nulo.")
    private String codigo;
    
   // @NotNull(message = "El tipo de viaje no puede ser nulo.")
    private String tipo; // "corta", "media", "larga"private TipoViaje tipo
    
    //@NotNull
    private double costo; // Costo base del viaje
    
    private boolean estado;

    //por ahora lo calculamos aqui luego lo podemos calcular en la base de datos
   /** public static double obtenerCostoBase(String tipo) {
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
        }**/
}
