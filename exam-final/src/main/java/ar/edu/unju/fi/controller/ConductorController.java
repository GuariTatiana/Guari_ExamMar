package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.model.Conductor;
import ar.edu.unju.fi.service.ConductorService;

@Controller 
public class ConductorController {

		@Autowired
		Conductor nuevoConductor;
		
		@Autowired
		ConductorService conductorService;
		

	@GetMapping({"/formularioConductor"})
		
		public ModelAndView getFormConductor() {
		//vista
		ModelAndView modelView =new ModelAndView ("formConductor");
		//agrega el objeto
		modelView.addObject("nuevoConductor", nuevoConductor);
		modelView.addObject("band", false);
		return modelView;		
		}


	@PostMapping("/guardarConductor")
	public ModelAndView saveConductor(@ModelAttribute("nuevoConductor") Conductor conductorParaGuardar) {
		
		//Guardar
		//ListadoConductores.agregarConductor(conductorParaGuardar);
		conductorService.guardarConductor(conductorParaGuardar);
		
		//Mostrar el listado
		ModelAndView modelView = new ModelAndView("index");
		//modelView.addObject("listadoConductores", ListadoConductores.listarConductores());	
		modelView.addObject("listadoConductores", conductorService.mostrarConductore());
		
		return modelView;		
	}

}
