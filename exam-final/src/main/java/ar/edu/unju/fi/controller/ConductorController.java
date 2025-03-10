package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.DTO.ConductorDTO;
//import ar.edu.unju.fi.model.Conductor;
import ar.edu.unju.fi.service.ConductorService;


@Controller 
public class ConductorController {

		//@Autowired
		//Conductor nuevoConductor;
		
		@Autowired
		ConductorDTO nuevoConductorDTO;
		
		@Autowired
		ConductorService conductorService;
		

	@GetMapping({"/formularioConductor"})
		
		public ModelAndView getFormConductor() {
		//vista
		ModelAndView modelView =new ModelAndView ("formConductor");
		//agrega el objeto
		modelView.addObject("nuevoConductor", nuevoConductorDTO);
		modelView.addObject("band", false);
		return modelView;		
		}


	@PostMapping("/guardarConductor")
	public ModelAndView saveConductor(@ModelAttribute("nuevoConductor") ConductorDTO conductorParaGuardar) {
		
		//Guardar
		//ListadoConductores.agregarConductor(conductorParaGuardar);
		conductorService.guardarConductor(conductorParaGuardar);
		
		//Mostrar el listado
		ModelAndView modelView = new ModelAndView("index");
		//modelView.addObject("listadoConductores", ListadoConductores.listarConductores());	
		modelView.addObject("listadoConductores", conductorService.mostrarConductore());
		
		return modelView;		
	}
	
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
		conductorService.eliminarConductor(codigo);
		
		//mostrar el nuevo listado
		ModelAndView modelView = new ModelAndView("index");
		modelView.addObject("listadoConductores", conductorService.mostrarConductore());	
		
		return modelView;		
		}
	
	@GetMapping("/modificarConductor/{codigo}")
	public ModelAndView getFormModificarConductor(@PathVariable Integer codigo) {
	    ModelAndView modelView = new ModelAndView("formConductor");
	    ConductorDTO conductor = conductorService.buscarConductor(codigo);
	    modelView.addObject("nuevoConductor", conductor);
	    modelView.addObject("band", true); 
	    return modelView;
	}

	@PostMapping("/modificarConductor")
	public ModelAndView updateConductor(@ModelAttribute("nuevoConductor") ConductorDTO conductorParaActualizar) {
		System.out.println("Conductor a actualizar: " + conductorParaActualizar);
		System.out.println("ID del conductor: " + conductorParaActualizar.getCodigo());
		conductorService.modificarConductor(conductorParaActualizar);
	    
	    ModelAndView modelView = new ModelAndView("index");
	    modelView.addObject("listadoConductores", conductorService.mostrarConductore());
	    
	    return modelView;
	}

}
