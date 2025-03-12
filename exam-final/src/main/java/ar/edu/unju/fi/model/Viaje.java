package ar.edu.unju.fi.model;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
    
   //@NotNull(message = "El tipo de viaje no puede ser nulo.")
    private String tipoViaje; // "corta", "media", "larga"private TipoViaje tipo
    
    //@NotNull
    //private double costo; // Costo base del viaje
    
    //private String tipoConductor;
    
    //private Conductor conductor;
    
    private double costo;
    
    private boolean estado;
    
    public boolean verificarDisponibilidadConductor(Conductor conductor) {
        return conductor.isEstado(); // Verifica si el conductor está activo
    }
    
    @ManyToMany 
    private List<Conductor> conductores;
    
    public void GuardarCostoTotal() {
     costo = calcularCostoTotal();
    }

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
        // Aquí puedes calcular el adicional basado en los conductores
        for (Conductor conductor : conductores) {
            if (conductor != null && conductor.getTipoAutomovil() != null) {
                String tipoAutomovil = conductor.getTipoAutomovil();
                switch (tipoAutomovil) {
                    case "Luxe":
                        adicional += obtenerCostoBase() * 0.1; // 10% adicional por conductor Luxe
                        break;
                    case "Premium":
                        adicional += obtenerCostoBase() * 0.2; // 20% adicional por conductor Premium
                        break;
                }
            }
        }
        return adicional;
    }
    
    
    
   /** private double obtenerAdicional() {
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
    }**/

   /**private double obtenerAdicional() {
        double adicional = 0;
        if (this.conductor != null && this.conductor.getTipoAutomovil() != null) {
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
    }
**/
    
}
