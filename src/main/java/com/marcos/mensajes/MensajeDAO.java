package com.marcos.mensajes;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;


@Repository
public interface MensajeDAO extends CrudRepository<MensajeDB,Long> 

{

	
}
