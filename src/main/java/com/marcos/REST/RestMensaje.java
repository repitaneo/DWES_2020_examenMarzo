package com.marcos.REST;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.marcos.mensajes.MensajeDB;



@RestController
public class RestMensaje {

		
    @PostMapping("/mensajeRobot")
    public void huevoFrito(@RequestBody MensajeDB mensaje) {
			
    	System.out.println("Servidor REST --- "+mensaje);
    }
	
}
