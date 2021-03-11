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
import com.intercam.autenticacion.entity.Direccion;
import com.intercam.autenticacion.exception.ResourceNotFoundException;
import com.intercam.autenticacion.service.DireccionService;


/**
 * Clase que expone los servicios REST de ventas Tellas Company
 * 
 * @author CBM
 *
 */
@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })
@RestController
@RequestMapping(path = "/direccion")
public class DireccionController {


	@Autowired
	//private DireccionRepository direccionRepository;
	DireccionService direccionService;


	/**
	 * Operaciones direccion
	 */
	@CrossOrigin(origins = "http://localhost:8080", methods = { RequestMethod.GET })
	@GetMapping(path = "/listarDireccion")
	public List<Direccion> getAllDireccion() {
		return direccionService.obtenerTodos();
	}


	@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.POST })
	@PostMapping("/addDireccion")
	public Direccion createDireccion(@Valid @RequestBody Direccion direccion) {
		return direccionService.guardar(direccion);
	}
	
	@GetMapping("/detalle/{id}")
	public ResponseEntity<Direccion> getOne(@PathVariable Long id) {
		if (!direccionService.existePorId(id))
			return new ResponseEntity(new Mensaje("no existe la dirección"), HttpStatus.NOT_FOUND);
		Direccion direccion = direccionService.obtenerPorId(id).get();
		return new ResponseEntity<Direccion>(direccion, HttpStatus.OK);
	}
	

	@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.PUT })
	@PutMapping("/updateDireccion/{id}")
	public ResponseEntity<Direccion> updateDireccion(@PathVariable(value = "id") Long idDireccion,
			@Valid @RequestBody Direccion direccionDetalle) throws ResourceNotFoundException {
		Direccion direccion = direccionService.obtenerPorId(idDireccion)
				.orElseThrow(() -> new ResourceNotFoundException("No existe la direccion" + idDireccion));

		
		direccion.setIdCliente(direccionDetalle.getIdCliente());
		direccion.setCalle(direccionDetalle.getCalle());
		direccion.setColonia(direccionDetalle.getColonia());
		direccion.setMunicipio(direccionDetalle.getMunicipio());
		direccion.setEstado(direccionDetalle.getEstado());
		direccion.setCp(direccionDetalle.getCp());
		
		
		final Direccion updateDireccion = direccionService.guardar(direccion);
		return ResponseEntity.ok(updateDireccion);
	}

	@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.DELETE })
	@DeleteMapping("/deleteDireccion/{id}")
	public Map<String, Boolean> deleteDireccion(@PathVariable(value = "id") Long idDireccion)
			throws ResourceNotFoundException {
		Direccion direccion = direccionService.obtenerPorId(idDireccion)
				.orElseThrow(() -> new ResourceNotFoundException("No existe la direccion" + idDireccion));

		direccionService.borrar(direccion.getIdDireccion());
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	/* Fin de las operaciones de direccion **/

	
}