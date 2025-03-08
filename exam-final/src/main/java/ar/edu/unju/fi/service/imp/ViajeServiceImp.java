package ar.edu.unju.fi.service.imp;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.model.Viaje;
import ar.edu.unju.fi.repository.ViajeRepository;
import ar.edu.unju.fi.service.ViajeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ViajeServiceImp implements ViajeService {

	@Autowired
	private ViajeRepository viajeRepository;
	
	@Override
	public void guardarViaje(Viaje viaje) {
		//viaje.setEstado(true);
		viajeRepository.save(viaje);
		//return viajeRepository.save(viaje);
	}

	@Override
	public List<Viaje> listarViajes() {
		// TODO Auto-generated method stub
		//listartodos los productos
		return viajeRepository.findAll();
	}

	
}
