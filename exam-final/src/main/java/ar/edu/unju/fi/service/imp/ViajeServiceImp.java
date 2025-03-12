package ar.edu.unju.fi.service.imp;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.model.Conductor;
import ar.edu.unju.fi.model.Viaje;
import ar.edu.unju.fi.repository.ConductorRepository;
import ar.edu.unju.fi.repository.ViajeRepository;
import ar.edu.unju.fi.service.ViajeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ViajeServiceImp implements ViajeService {

	@Autowired
	private ViajeRepository viajeRepository;
	
	@Autowired
    private ConductorRepository conductorRepository;
	
	/**@Override
	public void guardarViaje(Viaje viaje) {
		viaje.GuardarCostoTotal();
		viaje.setEstado(true);
		viajeRepository.save(viaje);
		//return viajeRepository.save(viaje);
	}**/
	
	@Override
	public void guardarViaje(Viaje viaje) {
		viaje.GuardarCostoTotal();
		viaje.setEstado(true);
	    for (Conductor conductor : viaje.getConductores()) {
	        if (!conductor.isDisponible()) {
	            throw new IllegalStateException("El conductor " + conductor.getNombre() + " no está disponible.");
	        }
	    }
	    
	    viajeRepository.save(viaje);
	    
	    // Marcar al conductor como no disponible
	    for (Conductor conductor : viaje.getConductores()) {
	        conductor.setDisponible(false); 
	        conductorRepository.save(conductor); 
	    }
	}

	@Override
	public List<Viaje> listarViajes() {
		// TODO Auto-generated method stub
		//listartodos los productos
		return viajeRepository.findAll();
	}

	
}
