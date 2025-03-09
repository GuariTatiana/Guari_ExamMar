package ar.edu.unju.fi.model;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Component
@Data
@Entity
public class Conductor {
	
		@Id
		@GeneratedValue
		private Integer codigo;
	
	    private String nombre;
		
		//@NotBlank
		//@Size(min=3, max=30, message="El apellido debe contener como mínimo 3 caracteres y como máximo 30 caracteres")
		//@Pattern(regexp= "[a-z A-Z]*", message="Debe ingresar únicamente letras")
	    private String apellido;
		
		//@NotNull
		//@Past (message="La fecha de nacimiento debe ser una fecha pasada")
	    private LocalDate fechaNac;
	    
	    //@NotNull
	    private String automovil;
	    
	    
	    //@Pattern(regexp = "^(X|Luxe|Premium)$", message = "El tipo de automóvil debe ser 'X', 'Luxe' o 'Premium'.")
	    private String tipoAutomovil; // "X", "Luxe", "Premium"
	    
	    private boolean estado;
	    
	    @ManyToMany(mappedBy = "conductores") 
	    private List<Viaje> viajes;
	    
	    //calcula la edad de una persona a partir de su fecha de nacimiento
	    //Period permite calcular la edad de manera precisa, teniendo en cuenta no solo los años, sino también los meses y días.
	    public int getEdad() {
	        return Period.between(fechaNac, LocalDate.now()).getYears();
	    }

}
