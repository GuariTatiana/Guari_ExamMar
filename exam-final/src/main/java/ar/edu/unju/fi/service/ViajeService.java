package ar.edu.unju.fi.service;

import java.util.List;

import org.springframework.stereotype.Service;


import ar.edu.unju.fi.model.Viaje;

@Service
public interface ViajeService {

	public void guardarViaje (Viaje viaje);
	public List<Viaje> listarViajes();
}
