package ar.edu.unju.fi.DTO;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Component
@Data
public class ConductorDTO {
	private Integer codigo;
    private String nombre;
    private String apellido;
    private LocalDate fechaNac;
    private String automovil;
    private String tipoAutomovil;
    private boolean estado;
    private int edad;
    private boolean disponible;
}
