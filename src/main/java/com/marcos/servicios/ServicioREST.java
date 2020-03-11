package com.marcos.servicios;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.marcos.mensajes.MensajeDB;

@Service
public class ServicioREST {

	
	public void enviarRobot(MensajeDB mensaje) throws URISyntaxException {
		
		
		URI myURL = new URI("http://localhost:8080/mensajeRobot");
		RequestEntity<MensajeDB> request = new RequestEntity<MensajeDB>(mensaje,HttpMethod.POST, myURL);
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<MensajeDB> response;
		restTemplate.exchange(request,MensajeDB.class); 		
	}
	
}
