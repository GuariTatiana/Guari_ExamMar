package ar.edu.unju.fi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.DTO.ConductorDTO;
//import ar.edu.unju.fi.model.Conductor;
import ar.edu.unju.fi.model.Conductor;

@Service
public interface ConductorService {

	//metodos abstractos de la interfaz
	
	public void guardarConductor(Conductor conductor);
	public List<ConductorDTO> mostrarConductore ();
	//proceso de borrado
	public void eliminarConductor(Integer codigo);
	public void modificarConductor(Conductor conductor);
	public Conductor buscarConductor(Integer codigo);
}
