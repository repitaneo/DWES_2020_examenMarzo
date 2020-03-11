package com.marcos.mensajes;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.marcos.servicios.ServicioId;
import com.marcos.servicios.ServicioREST;



@Controller
public class MensajeRutas {
	
	@Autowired
	private MensajeDAO mensajeDAO;
	
	@Autowired
	private ServicioId servicioId;

	@Autowired
	private ServicioREST servicioREST;

	
	
	@GetMapping("/informacion")
	public ModelAndView todosLosMensajes() {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("nuevomensaje");
		mav.addObject("mensajeIn",new Mensaje());
		
		return mav;
	}
	
	
	@GetMapping("/mensaje/{id}")
	public ModelAndView mensajesEditar(@PathVariable long id) {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("editarmensaje");
		mav.addObject("mensajeIn",mensajeDAO.findById(id));
		
		return mav;
	}
	
	
	@PostMapping("/editarMensaje")
	public ModelAndView editar(
			@Valid @ModelAttribute("mensajeIn") Mensaje mensaje,  
			BindingResult bindingResult) {
		
		ModelAndView mav = new ModelAndView();
		if(bindingResult.hasErrors()) {
			
			mav.setViewName("nuevomensaje");
			
		}else {
			
			MensajeDB mensajeDB = new MensajeDB();
			mensajeDB.setId(mensaje.getId());
			mensajeDB.setMensaje(mensaje.getMensaje());
			
			
			mensajeDAO.save(mensajeDB);
		}
		
		return mav;
	}	
	
	
	
	@PostMapping("/nuevoMensaje")
	public ModelAndView mensajesAnadir(
			@Valid @ModelAttribute("mensajeIn") Mensaje mensaje,  
			BindingResult bindingResult) {
		
		
		ModelAndView mav = new ModelAndView();
		if(bindingResult.hasErrors()) {
			
			mav.setViewName("nuevomensaje");
			
		}else {
			
			MensajeDB mensajeDB = new MensajeDB();
			mensajeDB.setId(servicioId.getID());
			mensajeDB.setMensaje(mensaje.getMensaje());
			
			//Humano
			if(mensaje.getTipo()==1) {
				mensajeDAO.save(mensajeDB);
			}
			// Robot
			else {
				try {
					servicioREST.enviarRobot(mensajeDB);
				
				} catch (URISyntaxException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		return mav;
	}
	
	
}
