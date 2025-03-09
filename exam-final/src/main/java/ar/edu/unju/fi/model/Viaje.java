package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
//import jakarta.validation.constraints.NotNull;
import lombok.Data;
@Component
@Data
@Entity
public class Viaje {
	
	@Id
	@GeneratedValue
	//@NotNull(message = "El ID del viaje no puede ser nulo.")
    private Integer codigo;
    
   // @NotNull(message = "El tipo de viaje no puede ser nulo.")
    private String tipoViaje; // "corta", "media", "larga"private TipoViaje tipo
    
    //@NotNull
    private double costo; // Costo base del viaje
    
    private String tipoConductor;
    
    //private Conductor conductor;
    
    private boolean estado;

    public double calcularCostoTotal() {
        double costoBase = obtenerCostoBase();
        double adicional = obtenerAdicional();
        return costoBase + adicional;
    }

    private double obtenerCostoBase() {
        switch (this.tipoViaje) {
            case "corta":
                return 7000;
            case "media":
                return 10000;
            case "larga":
                return 20000;
            default:
                return 0; // Manejo de caso inválido
        }
    }
    
    private double obtenerAdicional() {
    	double adicional = 0;
        switch (this.tipoConductor) {
        case "Luxe":
            adicional = obtenerCostoBase() * 0.1;
            break;
        case "Premium":
            adicional = obtenerCostoBase() * 0.2;
            break;
               
        }
        return adicional; // Manejo de caso inválido
    }

   /** private double obtenerAdicional() {
        double adicional = 0;
        if (this.conductor != null && this.conductor.getAutomovil() != null) {
            String tipoAutomovil = this.conductor.getTipoAutomovil() ;
            switch (tipoAutomovil) {
                case "Luxe":
                    adicional = obtenerCostoBase() * 0.1;
                    break;
                case "Premium":
                    adicional = obtenerCostoBase() * 0.2;
                    break;
            }
        }
        return adicional;
    }**/

    
    //por ahora lo calculamos
    /**public static double obtenerCostoBase(String tipoViaje) {
        switch (tipoViaje.toLowerCase()) {
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
