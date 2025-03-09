package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;


import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


import ar.edu.unju.fi.model.Viaje;
import ar.edu.unju.fi.service.ViajeService;
//import ar.edu.unju.fi.service.ConductorService;


@Controller 
public class ViajeController {

	//@Autowired
	//Viaje nuevoViaje;
	
	@Autowired
	ViajeService viajeService;
	
	//@Autowired
    //private ConductorService conductorService;
	

	//muestro html que cree
	@GetMapping({"/formularioViajes"})
	public ModelAndView getFormViaje() {
	//vista
	ModelAndView modelView =new ModelAndView ("formViaje");//Nombre de la vista
	//agrega el objeto
	modelView.addObject("viaje", new Viaje());//pasar producto al modelo
	
	 //modelView.addObject("listadoConductores", conductorService.mostrarConductore());
	
	//modelView.addObject("band", false);
	return modelView;//devolver 		
	}

	//metodo para guardar el producto
	@PostMapping("/viaje/guardar")
	public ModelAndView guardarViaje(Viaje viaje) {
		viajeService.guardarViaje(viaje); // Llamar al servicio para guardar el producto en bd
		// Redirigir a la lista de viajes
		ModelAndView modelAndView = new ModelAndView("formViaje");
		
		//modelAndView.addObject("listadoConductores", conductorService .mostrarConductore()); // Obtener la lista de conductores
		
		modelAndView.addObject("viaje", new Viaje()); // Pasar un nuevo objeto Producto al modelo (campos vacíos)
		modelAndView.addObject("mensaje", "Viaje guardado con éxito!"); // Mensaje de éxito
        return modelAndView;
			
	}
	
	
	

}
	
	//@GetMapping("/viaje/listar")
    //public ResponseEntity<String> listarViajes() {
        // Devolver un mensaje simple
        //return ResponseEntity.ok("No hay viajes disponibles en este momento.");
    //}
//}
