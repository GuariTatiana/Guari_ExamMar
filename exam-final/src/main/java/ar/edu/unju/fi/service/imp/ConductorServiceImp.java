package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.model.Conductor;
import ar.edu.unju.fi.repository.ConductorRepository;
import ar.edu.unju.fi.service.ConductorService;

@Service
public class ConductorServiceImp implements ConductorService{

	@Autowired
	ConductorRepository conductorRepository;
	
	@Override
	public void guardarConductor(Conductor conductor) {
		// TODO Auto-generated method stub
		//conductor viene del controller, solo se esta guardando
		//por si no viene con estado ponemos:
		//conductor.setEstado(true);
		conductorRepository.save(conductor);
		
	}

	@Override
	public List<Conductor> mostrarConductore() {
		// TODO Auto-generated method stub
		return conductorRepository.findAll();
	}

}
