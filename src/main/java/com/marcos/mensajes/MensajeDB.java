package com.marcos.mensajes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MensajeDB {

	@Id
	private Long id;
	
	@Column
	private String mensaje;

	
	
	
	
	
	
	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Mensaje [id=" + id + ", mensaje=" + mensaje + "]";
	}


	
	
	
	
	
}
