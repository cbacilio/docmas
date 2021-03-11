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
import com.intercam.autenticacion.entity.Cliente;
import com.intercam.autenticacion.entity.Producto;
import com.intercam.autenticacion.exception.ResourceNotFoundException;
import com.intercam.autenticacion.service.ProductoService;

/**
 * Clase que expone los servicios REST de ventas Tellas Company
 * 
 * @author CBM
 *
 */
@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })
@RestController
@RequestMapping(path = "/producto")
public class ProductoController {

	@Autowired
	ProductoService productoService;

	/**
	 * Operaciones producto
	 */
	@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.GET })
	@GetMapping(path = "/listarProducto")
	public List<Producto> getAllProducto() {
		return productoService.obtenerTodos();
	}

	@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.POST })
	@PostMapping("/addProducto")
	public Producto createProducto(@Valid @RequestBody Producto producto) {
		return productoService.guardar(producto);
	}

	@GetMapping("/detalle/{id}")
	public ResponseEntity<Producto> getOne(@PathVariable Long id) {
		if (!productoService.existePorId(id))
			return new ResponseEntity(new Mensaje("no existe el producto"), HttpStatus.NOT_FOUND);
		Producto producto = productoService.obtenerPorId(id).get();
		return new ResponseEntity<Producto>(producto, HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.PUT })
	@PutMapping("/updateProducto/{id}")
	public ResponseEntity<Producto> updateProducto(@PathVariable(value = "id") Long idProducto,
			@Valid @RequestBody Producto productoDetalle) throws ResourceNotFoundException {
		Producto producto = productoService.obtenerPorId(idProducto)
				.orElseThrow(() -> new ResourceNotFoundException("No existe el producto" + idProducto));

		producto.setDescripcion(productoDetalle.getDescripcion());

		final Producto updateProducto = productoService.guardar(producto);
		return ResponseEntity.ok(updateProducto);
	}

	@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.DELETE })
	@DeleteMapping("/deleteProducto/{id}")
	public Map<String, Boolean> deleteProducto(@PathVariable(value = "id") Long idProducto)
			throws ResourceNotFoundException {
		Producto producto = productoService.obtenerPorId(idProducto)
				.orElseThrow(() -> new ResourceNotFoundException("No existe el producto" + idProducto));

		productoService.borrar(producto.getIdProducto());
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	/* Fin de las operaciones de productos **/

}