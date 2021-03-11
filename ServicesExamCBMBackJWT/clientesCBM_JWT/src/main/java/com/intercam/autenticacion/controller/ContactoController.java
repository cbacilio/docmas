package com.intercam.autenticacion.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.intercam.autenticacion.dto.Mensaje;
import com.intercam.autenticacion.entity.Abono;
import com.intercam.autenticacion.entity.Contacto;
import com.intercam.autenticacion.exception.ResourceNotFoundException;
import com.intercam.autenticacion.service.ContactoService;



/**
 * Clase que expone los servicios REST de ventas Tellas Company
 * 
 * @author CBM
 *
 */
@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })
@RestController
@RequestMapping(path = "/contacto")
public class ContactoController {


	@Autowired
	private ContactoService contactoService;	
	
	/**
	 * Operaciones contacto
	 */
	@CrossOrigin(origins = "http://localhost:8080", methods = { RequestMethod.GET })
	@GetMapping(path = "/listarContacto")
	public List<Contacto> getAllContacto() {
		return contactoService.obtenerTodos();
	}

	@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.POST })
	@PostMapping("/addContacto")
	public Contacto createContacto(@Valid @RequestBody Contacto contacto) {
		return contactoService.guardar(contacto);
	}
	
	@GetMapping("/detalle/{id}")
	public ResponseEntity<Contacto> getOne(@PathVariable Long id) {
		if (!contactoService.existePorId(id))
			return new ResponseEntity(new Mensaje("no existe el contacto"), HttpStatus.NOT_FOUND);
		Contacto contacto = contactoService.obtenerPorId(id).get();
		return new ResponseEntity<Contacto>(contacto, HttpStatus.OK);
	}
	

	@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.PUT })
	@PutMapping("/updateContacto/{id}")
	public ResponseEntity<Contacto> updateContacto(@PathVariable(value = "id") Long idContacto,
			@Valid @RequestBody Contacto contactoDetalle) throws ResourceNotFoundException {
		Contacto contacto = contactoService.obtenerPorId(idContacto)
				.orElseThrow(() -> new ResourceNotFoundException("No existe el contacto" + idContacto));

		contacto.setIdCliente(contactoDetalle.getIdCliente());
		contacto.setEmail(contactoDetalle.getEmail());
		contacto.setTelefono(contactoDetalle.getTelefono());	
		final Contacto updateContacto = contactoService.guardar(contacto);
		return ResponseEntity.ok(updateContacto);
	}

	@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.DELETE })
	@DeleteMapping("/deleteContacto/{id}")
	public Map<String, Boolean> deleteContacto(@PathVariable(value = "id") Long idContacto)
			throws ResourceNotFoundException {
		Contacto contacto = contactoService.obtenerPorId(idContacto)
				.orElseThrow(() -> new ResourceNotFoundException("No existe el contacto" + idContacto));

		contactoService.borrar(contacto.getIdContacto());
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	/* Fin de las operaciones de contacto **/

	
}