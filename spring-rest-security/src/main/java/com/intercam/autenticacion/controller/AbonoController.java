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
import com.intercam.autenticacion.entity.Producto;
import com.intercam.autenticacion.exception.ResourceNotFoundException;
import com.intercam.autenticacion.service.AbonoService;



@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })
@RestController
@RequestMapping(path = "/abono")
public class AbonoController {

	@Autowired
	AbonoService abonoService;
	//private AbonoRepository abonoRepository;

	/**
	 * Operaciones abono
	 */
	@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.GET })
	@GetMapping(path = "/listarAbono")
	public List<Abono> getAllAbono() {
		return abonoService.obtenerTodos();
	}

	@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.POST })
	@PostMapping("/addAbono")
	public Abono createAbono(@Valid @RequestBody Abono abono) {
		return abonoService.guardar(abono);
	}

	@GetMapping("/detalle/{id}")
	public ResponseEntity<Abono> getOne(@PathVariable Long id) {
		if (!abonoService.existePorId(id))
			return new ResponseEntity(new Mensaje("no existe el abono"), HttpStatus.NOT_FOUND);
		Abono abono = abonoService.obtenerPorId(id).get();
		return new ResponseEntity<Abono>(abono, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.PUT })
	@PutMapping("/updateAbono/{id}")
	public ResponseEntity<Abono> updateAbono(@PathVariable(value = "id") Long idAbono,
			@Valid @RequestBody Abono abonoDetalle) throws ResourceNotFoundException {
		Abono abono = abonoService.obtenerPorId(idAbono)
				.orElseThrow(() -> new ResourceNotFoundException("No existe el abono" + idAbono));

		abono.setMonto(abonoDetalle.getMonto());
		abono.setFecha(abonoDetalle.getFecha()); 

		final Abono updateAbono = abonoService.guardar(abono);
		
		return ResponseEntity.ok(updateAbono);
	}

	@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.DELETE })
	@DeleteMapping("/deleteAbono/{id}")
	public Map<String, Boolean> deleteAbono(@PathVariable(value = "id") Long IdAbono)
			throws ResourceNotFoundException {
		Abono abono = abonoService.obtenerPorId(IdAbono)
				.orElseThrow(() -> new ResourceNotFoundException("No existe el abono" + IdAbono));

		abonoService.borrar(abono.getIdAbono());
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	/* Fin de las operaciones de abono **/
	
	
}