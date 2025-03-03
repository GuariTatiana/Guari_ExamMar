package ar.edu.unju.fi.model;
import java.time.LocalDate;
import java.time.Period;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Component
@Data
public class Conductor {
		@NotNull (message = "El Id del conductor no puede ser nulo")
		private int id;
		
		@NotBlank
		@Size(min=3, max=30, message="El nombre debe contener como mínimo 3 caracteres y como máximo 30 caracteres")
		@Pattern(regexp= "[a-z A-Z]*", message="Debe ingresar únicamente letras")
	    private String nombre;
		
		@NotBlank
		@Size(min=3, max=30, message="El apellido debe contener como mínimo 3 caracteres y como máximo 30 caracteres")
		@Pattern(regexp= "[a-z A-Z]*", message="Debe ingresar únicamente letras")
	    private String apellido;
		
		@NotNull
		@Past (message="La fecha de nacimiento debe ser una fecha pasada")
	    private LocalDate fechaNac;
	    
	    @NotNull
	    private String automovil;
	    
	    @NotBlank(message = "El tipo de automóvil no puede estar en blanco.")
	    @Pattern(regexp = "^(Base|Luxe|Premium)$", message = "El tipo de automóvil debe ser 'Base', 'Luxe' o 'Premium'.")
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
