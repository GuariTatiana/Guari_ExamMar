package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
//import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.DTO.ConductorDTO;
import ar.edu.unju.fi.map.ConductorMapDTO;
import ar.edu.unju.fi.model.Conductor;
//import ar.edu.unju.fi.model.Conductor;
import ar.edu.unju.fi.service.ConductorService;
import jakarta.validation.Valid;
//import jakarta.validation.Valid;


@Controller 
public class ConductorController {

		//@Autowired
		//Conductor nuevoConductor;
		@Autowired
		ConductorMapDTO conductorMapDTO;
		
		@Autowired
		ConductorDTO nuevoConductorDTO;
		
		@Autowired
		ConductorService conductorService;
		

	@GetMapping({"/formularioConductor"})
		
		public ModelAndView getFormConductor() {
		//vista crea un nuevo objeto
		ModelAndView modelView =new ModelAndView ("formConductor");
		//agrega el nuevo objeto
		modelView.addObject("nuevoConductor", nuevoConductorDTO);
		modelView.addObject("band", false);
		return modelView;		
		}

	/**@PostMapping("/guardarConductor")
	public ModelAndView saveConductor(@Valid @ModelAttribute("nuevoConductor") Conductor conductorParaGuardar, BindingResult resultado) {
		
		//Guardar
		//ListadoConductores.agregarConductor(conductorParaGuardar);
		conductorService.guardarConductor(conductorParaGuardar);
		
		//Mostrar el listado
		ModelAndView modelView = new ModelAndView("index");
		//modelView.addObject("listadoConductores", ListadoConductores.listarConductores());	
		modelView.addObject("listadoConductores", conductorService.mostrarConductore());
		
		return modelView;		
	}**/
	
	@PostMapping("/guardarConductor")
	public ModelAndView saveConductor(@Valid @ModelAttribute("nuevoConductor") Conductor conductorParaGuardar, BindingResult resultado) {
		ModelAndView modelView = new ModelAndView();
		//modelView.addObject("listadoConductores", conductorService.mostrarConductore());
		
		try{
			// Verificar la edad
	        if (conductorParaGuardar.getEdad() < 18) {
	            resultado.rejectValue("fechaNac", "error.fechaNac", "Debes tener al menos 18 años.");
	        }
			
			if (resultado.hasErrors()) {
				// Si hay errores de validacion, redirige al formulario
				modelView.setViewName("formConductor");
				modelView.addObject("band", false);
				modelView.addObject("listadoConductores", conductorService.mostrarConductore());
				
				
			}else {
				// Si no hay errores, guarda el conductor
	            conductorParaGuardar.setDisponible(conductorParaGuardar.isDisponible());
				//conductorParaGuardar.setConductor(conductorService.buscarCarrera(alumnoParaGuardar.getCarrera().getCodigo()));
				conductorService.guardarConductor(conductorParaGuardar);
				
				 // Línea de depuración para verificar la lista de conductores después de guardar
	            System.out.println("Conductores después de guardar: " + conductorService.mostrarConductore());
	            
				// Redirige a la vista de índice después de guardar
	            modelView.setViewName("index");
				modelView.addObject("listadoConductores", conductorService.mostrarConductore());
				//Guardar
				//ListadoConductores.agregarConductor(conductorParaGuardar);
				//conductorService.guardarConductor(conductorParaGuardar);
				//Mostrar el listado
				//modelView.setViewName("index");
				//modelView.addObject("listadoConductores", ListadoConductores.listarConductores());	
				
				
			}
		}
		catch( Exception e) {
			boolean errors = true;
			modelView.addObject("errors", errors);
			modelView.addObject("cargaConductorErrorMessage", " Error al cargar en la BD " + e.getMessage());
			System.out.println(e.getMessage());
		}
		
		return modelView;		
	}
	
	/**@PostMapping("/guardarConductor")
	public ModelAndView saveConductor(@Valid @ModelAttribute("nuevoConductor") ConductorDTO conductorParaGuardar, BindingResult resultado) {
		ModelAndView modelView = new ModelAndView();
			if (resultado.hasErrors()) {
				// Si hay errores, redirige al formulario
				modelView.setViewName("formConductor");
				
			}else {
				// Si no hay errores, guarda el conductor
				//conductorParaGuardar.setConductor(conductorService.buscarCarrera(alumnoParaGuardar.getCarrera().getCodigo()));
				conductorService.guardarConductor(conductorParaGuardar);
				// Redirige a la vista de índice después de guardar
	            //modelView.setViewName("index");
				//modelView.addObject("listadoConductores", conductorService.mostrarConductore());
				//Guardar
				//ListadoConductores.agregarConductor(conductorParaGuardar);
				//conductorService.guardarConductor(conductorParaGuardar);
				//Mostrar el listado
				modelView.setViewName("index");
				modelView.addObject("listadoConductores", conductorService.mostrarConductore());
			}
		
		return modelView;		
	}**/
	
	//muestra la lista de conductores
	@GetMapping("/index")
	public ModelAndView mostrarListaConductores() {
	    ModelAndView modelView = new ModelAndView("index");
	    modelView.addObject("listadoConductores", conductorService.mostrarConductore());
	    return modelView;
	}
	
	@GetMapping("/eliminarConductor/{codigo}")
	public ModelAndView borrarConductor (@PathVariable Integer codigo) {
		//borrar
		//ListadoConductores.eliminarConductor(codigo);
		//llamamos al servicio para eliminar conductor de BD
		conductorService.eliminarConductor(codigo);
		
		//mostrar el nuevo listado
		ModelAndView modelView = new ModelAndView("index");
		//actualiza la lista
		modelView.addObject("listadoConductores", conductorService.mostrarConductore());	
		
		return modelView;		
		}
	
	@GetMapping("/modificarConductor/{codigo}")
	public ModelAndView getFormModificarConductor(@PathVariable Integer codigo) {
	    ModelAndView modelView = new ModelAndView("formConductor");
	    Conductor conductor = conductorService.buscarConductor(codigo);
	    //conductor encontrado
	    modelView.addObject("nuevoConductor", conductor);
	    modelView.addObject("band", true); 
	    return modelView;
	}

	@PostMapping("/modificarConductor")
	public ModelAndView updateConductor(@Valid @ModelAttribute("nuevoConductor") Conductor conductorParaActualizar, BindingResult resultado) {
		// Verificar la edad
        if (conductorParaActualizar.getEdad() < 18) {
            resultado.rejectValue("fechaNac", "error.fechaNac", "Debes tener al menos 18 años.");
        }
		if (resultado.hasErrors()) {
			ModelAndView modelView = new ModelAndView("formConductor");
	        modelView.addObject("band", true);
	        modelView.addObject("nuevoConductor", conductorParaActualizar); 
	        return modelView;
		}
		System.out.println("Conductor a actualizar: " + conductorParaActualizar);
		System.out.println("ID del conductor: " + conductorParaActualizar.getCodigo());
		conductorParaActualizar.setDisponible(conductorParaActualizar.isDisponible());
		//llama al servicio para actualizar conductor en la bd
		conductorService.modificarConductor(conductorParaActualizar);
	    //crea objeto
	    ModelAndView modelView = new ModelAndView("index");
	    modelView.addObject("listadoConductores", conductorService.mostrarConductore());
	    
	    return modelView;
	}

}
