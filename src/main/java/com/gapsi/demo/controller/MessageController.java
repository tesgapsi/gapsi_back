package com.gapsi.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gapsi.demo.dto.InfoSystem;


/**
*
* @author jonatan.mendez
*/

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/info")
public class MessageController {
	
	/**
     * Method with return message welcome
     * @param 
     * @return String
     * @throws ResponseEntity
     */
	@GetMapping("/welcome")
	public ResponseEntity<String> showWelcome() {
		String message= "Bienvenido Candidato 01";

			return new ResponseEntity<>(message, HttpStatus.OK);
	}
	
	/**
     * Method with return aplication tecnical information 
     * @param 
     * @return String
     * @throws ResponseEntity
     */
	@GetMapping("")
	public ResponseEntity<InfoSystem> showSpecInfo() {
		InfoSystem info = new InfoSystem();
		info.setTitl("Test Gapsi");
		info.setDescription("Sistema de ejemplo para evaluacion gapsi, propuesta lider tecnico en tecnologias java");
		info.setVersion("Relase: 0.0.1");
		
		return new ResponseEntity<>(info, HttpStatus.OK);
	}

}
