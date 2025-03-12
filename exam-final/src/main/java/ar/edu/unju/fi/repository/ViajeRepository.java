package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.model.Viaje;



@Repository
public interface ViajeRepository extends JpaRepository <Viaje, Integer>{

	List <Viaje> findViajeByEstado (Boolean estado);
	// Método para encontrar viajes por conductor
    List<Viaje> findByConductores_Codigo(Integer conductorId);

}
