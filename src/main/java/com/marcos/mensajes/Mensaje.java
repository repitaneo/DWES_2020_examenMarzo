package com.marcos.mensajes;

import javax.validation.constraints.Size;

public class Mensaje {

	
	private Long id;

	@Size(min=5, message="el nombre no puede ser pequeño")
	private String mensaje;
	private Long tipo;	
	
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}	
	
	
	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Long getTipo() {
		return tipo;
	}

	public void setTipo(Long tipo) {
		this.tipo = tipo;
	}


	@Override
	public String toString() {
		return "Mensaje [mensaje=" + mensaje + ", tipo=" + tipo + "]";
	}


	
	
	
	
	
}
