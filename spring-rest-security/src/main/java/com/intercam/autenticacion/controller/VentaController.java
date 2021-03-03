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
import com.intercam.autenticacion.entity.Venta;
import com.intercam.autenticacion.exception.ResourceNotFoundException;
import com.intercam.autenticacion.service.VentaService;


/**
 * Clase que expone los servicios REST de ventas Tellas Company
 * 
 * @author CBM
 *
 */
@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })
@RestController
@RequestMapping(path = "/venta")
public class VentaController {

	@Autowired
	private VentaService ventaService;

	/**
	 * Operaciones venta
	 */
	@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.GET })
	@GetMapping(path = "/listarVenta")
	public List<Venta> getAllVenta() {
		return ventaService.obtenerTodos();
	}

	@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.POST })
	@PostMapping("/addVenta")
	public Venta createProducto(@Valid @RequestBody Venta venta) {
		return ventaService.guardar(venta);
	}
	
	@GetMapping("/detalle/{id}")
	public ResponseEntity<Venta> getOne(@PathVariable Long id) {
		if (!ventaService.existePorId(id))
			return new ResponseEntity(new Mensaje("no existe la venta"), HttpStatus.NOT_FOUND);
		Venta venta = ventaService.obtenerPorId(id).get();
		return new ResponseEntity<Venta>(venta, HttpStatus.OK);
	}
	

	@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.PUT })
	@PutMapping("/updateVenta/{id}")
	public ResponseEntity<Venta> updateVenta(@PathVariable(value = "id") Long idVenta,
			@Valid @RequestBody Venta ventaDetalle) throws ResourceNotFoundException {
		Venta venta = ventaService.obtenerPorId(idVenta)
				.orElseThrow(() -> new ResourceNotFoundException("No existe la venta" + idVenta));

		
		venta.setDescripcion(ventaDetalle.getDescripcion());

		
		final Venta updateVenta = ventaService.guardar(venta);
		return ResponseEntity.ok(updateVenta);
	}

	@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.DELETE })
	@DeleteMapping("/deleteVenta/{id}")
	public Map<String, Boolean> deleteVenta(@PathVariable(value = "id") Long idVenta)
			throws ResourceNotFoundException {
		Venta venta = ventaService.obtenerPorId(idVenta)
				.orElseThrow(() -> new ResourceNotFoundException("No existe la venta" + idVenta));

		ventaService.borrar(venta.getIdVenta());
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	/* Fin de las operaciones de venta **/
}