package ar.edu.unju.fi.model;

import java.time.LocalDate;

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
	    private boolean estado;
	    
	
}
