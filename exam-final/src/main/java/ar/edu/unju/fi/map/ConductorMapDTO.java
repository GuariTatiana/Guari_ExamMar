package ar.edu.unju.fi.map;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import ar.edu.unju.fi.DTO.ConductorDTO;
import ar.edu.unju.fi.model.Conductor;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)

public interface ConductorMapDTO {
	

	@Mapping(source="codigo", target="codigo")
	@Mapping(source="nombre", target="nombre")
	@Mapping(source="apellido", target="apellido")	
	@Mapping(source="fechaNac", target="fechaNac")
	@Mapping(source="automovil", target="automovil")
	@Mapping(source="tipoAutomovil", target="tipoAutomovil")
	@Mapping(source="estado", target="estado")
	@Mapping(target = "edad", expression = "java(java.time.Period.between(c.getFechaNac(), java.time.LocalDate.now()).getYears())") // Calcular la edad
	
	
	ConductorDTO convertirConductorAConductorDTO (Conductor c);
	
	@Mapping(target ="viajes", ignore = true)

	@InheritInverseConfiguration
	Conductor convertirConductorDTOAConductor (ConductorDTO cdto);

	List<ConductorDTO> convertirListaConductoresAListaConductoresDTO(List<Conductor> listaC);
	
	List<Conductor> convertirListaConductoresDTOAListaConductores(List<ConductorDTO> listaCDTO);
	
}
