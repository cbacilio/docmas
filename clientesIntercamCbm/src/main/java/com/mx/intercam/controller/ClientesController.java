package com.mx.intercam.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mx.intercam.model.entitys.TipoPago;
import com.mx.intercam.model.repository.TipoPagoRepository;


/**
 *
 * @author CBM
 *
 */
@CrossOrigin(origins = "http://localhost:4200",
methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping(path="/pagos")
public class ClientesController {
	
	@Autowired
	private TipoPagoRepository tipoPagoRepository;

	@CrossOrigin(origins = "http://localhost:4200",
			methods= {RequestMethod.GET})
	@GetMapping(path="/listar")
	public List<TipoPago> getAllInventario() {
		return tipoPagoRepository.findAll();
	}

//	
//	@GetMapping("/listar/{id}")
//	public ResponseEntity<Cliente> getClienteById(@PathVariable(value = "id") Long clienteId)
//			throws ResourceNotFoundException {
//		Cliente cliente = clienteRepository.findById(clienteId)
//				.orElseThrow(() -> new ResourceNotFoundException("No existe el cliente" + clienteId));
//		return ResponseEntity.ok().body(cliente);
//	}
//	@CrossOrigin(origins = "http://localhost:4200",
//			methods= {RequestMethod.POST})
//	@PostMapping("/add")
//	public Cliente createCliente(@Valid @RequestBody Cliente cliente) {
//		return clienteRepository.save(cliente);
//	}
//
//	@CrossOrigin(origins = "http://localhost:4200",
//			methods= {RequestMethod.PUT})
//	@PutMapping("/update/{id}")
//	public ResponseEntity<Cliente> updateCliente(@PathVariable(value = "id") Long clienteId,
//			@Valid @RequestBody Cliente clienteDetalle) throws ResourceNotFoundException {
//		Cliente cliente = clienteRepository.findById(clienteId)
//				.orElseThrow(() -> new ResourceNotFoundException("No existe el cliente" + clienteId));
//
//		cliente.setNombre(clienteDetalle.getNombre());
//		cliente.setApellidoPaterno(clienteDetalle.getApellidoPaterno());
//		cliente.setApellidoMaterno(clienteDetalle.getApellidoMaterno());
//		cliente.setFechaNacimiento(clienteDetalle.getFechaNacimiento());
//		cliente.setIngresos(clienteDetalle.getIngresos());
//		cliente.setCodigoPostal(clienteDetalle.getCodigoPostal());
//		
//		final Cliente updatedCliente = clienteRepository.save(cliente);
//		return ResponseEntity.ok(updatedCliente);
//	}
//
//	@CrossOrigin(origins = "http://localhost:4200",
//			methods= {RequestMethod.DELETE})
//	@DeleteMapping("/delete/{id}")
//	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long clienteId)
//			throws ResourceNotFoundException {
//		Cliente cliente = clienteRepository.findById(clienteId)
//				.orElseThrow(() -> new ResourceNotFoundException("No existe el cliente" + clienteId));
//
//		clienteRepository.delete(cliente);
//		Map<String, Boolean> response = new HashMap<>();
//		response.put("deleted", Boolean.TRUE);
//		return response;
//	}
//	
}