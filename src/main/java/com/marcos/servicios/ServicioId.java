package com.marcos.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.marcos.mensajes.*;

import com.marcos.mensajes.MensajeDAO;

@Service
public class ServicioId {

	@Autowired
	private MensajeDAO mensajeDAO;
	
	
	public long getID() {
		
		long id = 1;
		Optional<MensajeDB> mensaje = mensajeDAO.findById(id);
		while(mensaje.isPresent()) {
			
			id++;
			mensaje = mensajeDAO.findById(id);
		}
		
		return id;
		
	}
	
}
