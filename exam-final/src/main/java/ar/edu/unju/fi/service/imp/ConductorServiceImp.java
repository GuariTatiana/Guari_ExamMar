package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.DTO.ConductorDTO;
import ar.edu.unju.fi.map.ConductorMapDTO;
import ar.edu.unju.fi.model.Conductor;
import ar.edu.unju.fi.repository.ConductorRepository;
import ar.edu.unju.fi.service.ConductorService;

@Service
public class ConductorServiceImp implements ConductorService{

	@Autowired
	ConductorRepository conductorRepository;
	
	@Autowired
	ConductorMapDTO conductorMapDTO;
	
	@Override
	public void guardarConductor(ConductorDTO conductorDTO) {
		// TODO Auto-generated method stub
		//conductor viene del controller, solo se esta guardando
		 Conductor conductor = conductorMapDTO.convertirConductorDTOAConductor(conductorDTO);
		//por si no viene con estado ponemos:
		conductor.setEstado(true);
		//conductorRepository.save(conductorMapDTO.convertirConductorDTOAConductor(conductorDTO));
		 conductorRepository.save(conductor);
	}

	@Override
	public List<ConductorDTO> mostrarConductore() {
		// TODO Auto-generated method stub
		//return conductorRepository.findAll();
		// Devuelve solo los conductores activos
		//return conductorRepository.findConductorByEstado(true);
		// Obtiene la lista de conductores activos
	    List<Conductor> conductores = conductorRepository.findConductorByEstado(true);
	    
	    // Convierte la lista de conductores a lista de DTOs
	    return conductorMapDTO.convertirListaConductoresAListaConductoresDTO(conductores);
	}
	
	
	@Override
	public void eliminarConductor (Integer codigo) {

		List<Conductor> conductores = conductorRepository.findAll();
		for(Conductor i : conductores) {
			if(i.getCodigo() .equals(codigo)) {
				i.setEstado(false);
				conductorRepository.save(i);
			}
		}
	}

	@Override
	public void modificarConductor(ConductorDTO conductorDTO) {
		// Convierte el DTO a la entidad Conductor
        Conductor conductor = conductorMapDTO.convertirConductorDTOAConductor(conductorDTO);
        
		// Verifica si el conductor existe
	    if (conductorRepository.existsById(conductor.getCodigo())) {
	        // Establece el estado del conductor
	        conductor.setEstado(true);
	        // Guarda el conductor (esto actualizará el registro existente)
	        conductorRepository.save(conductor);
	    } else {
	        System.out.println("Conductor no encontrado para modificar: " + conductor.getCodigo());
	    }
	}

	@Override
	public ConductorDTO buscarConductor(Integer codigo) {
		// TODO Auto-generated method stub
		
		List<Conductor> conductores = conductorRepository.findAll();
		for (Conductor a : conductores) {
			if(a.getCodigo().equals(codigo)) {
				//return a;
				// Convierte el Conductor a ConductorDTO antes de devolverlo
	            return conductorMapDTO.convertirConductorAConductorDTO(a);
			}
		}
		return null;
	}

}
