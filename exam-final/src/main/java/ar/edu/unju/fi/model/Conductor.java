package ar.edu.unju.fi.model;
import java.time.LocalDate;
import java.time.Period;

import org.springframework.stereotype.Component;


import lombok.Data;

@Component
@Data
public class Conductor {

		private int id;
	    private String nombre;
	    private String apellido;
	    private LocalDate fechaNac;
	    private String automovil;
	    private String tipoAutomovil; // "X", "Luxe", "Premium"
	    
	    public int getEdad() {
	        return Period.between(fechaNac, LocalDate.now()).getYears();
	    }

	    public double calcularCostoViaje(Viaje viaje) {
	        double costoBase = viaje.getCosto();
	        switch (tipoAutomovil) {
	            case "Luxe":
	                return costoBase * 1.10; // 10% adicional
	            case "Premium":
	                return costoBase * 1.20; // 20% adicional
	            default:
	                return costoBase; // Tarifa base
	        }
	    }
}
