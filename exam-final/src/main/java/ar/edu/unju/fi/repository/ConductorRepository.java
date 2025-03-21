package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.model.Conductor;

@Repository
public interface ConductorRepository extends JpaRepository <Conductor, Integer> {

	//List <Conductor> findConductorByEstado (Boolean estado);
    //List<Conductor> findConductorByEstadoAndDisponible(boolean estado, boolean disponible);
	List<Conductor> findConductorByEstado(boolean estado);
    List<Conductor> findConductorByDisponible(boolean disponible);
}
