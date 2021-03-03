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
import com.intercam.autenticacion.entity.ProductoJWT;
import com.intercam.autenticacion.exception.ResourceNotFoundException;
import com.intercam.autenticacion.repository.ClienteRepository;
import com.intercam.autenticacion.service.ClienteService;


/**
 * Clase que expone los servicios REST de ventas Tellas Company
 * 
 * @author CBM
 *
 */
@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })
@RestController
@RequestMapping(path = "/cliente")
public class ClienteController {


	/*@Autowired
	private ClienteRepository clienteRepository;*/
	
    @Autowired
    ClienteService clienteService;

	
	/**
	 * Operaciones cliente
	 */
	@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.GET })
	@GetMapping(path = "/listarCliente")
	public List<Cliente> getAllCliente() {
		return clienteService.obtenerTodos();
	}
    @GetMapping("/detalle/{id}")
    public ResponseEntity<Cliente> getOne(@PathVariable Long id){
        if(!clienteService.existePorId(id))
            return new ResponseEntity(new Mensaje("no existe el cliente"), HttpStatus.NOT_FOUND);
        Cliente cliente = clienteService.obtenerPorId(id).get();
        return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
    }

	@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.POST })
	@PostMapping("/addCliente")
	public Cliente createCliente(@Valid @RequestBody Cliente cliente) {
		 return clienteService.guardar(cliente);
	}

	@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.PUT })
	@PutMapping("/updateCliente/{id}")
	public ResponseEntity<Cliente> updateCliente(@PathVariable(value = "id") Long idCliente,
			@Valid @RequestBody Cliente clienteDetalle) throws ResourceNotFoundException {
		Cliente cliente = clienteService.obtenerPorId(idCliente)
				.orElseThrow(() -> new ResourceNotFoundException("No existe el cliente" + idCliente));

		cliente.setIdCliente(clienteDetalle.getIdCliente());
		cliente.setIdDireccion(clienteDetalle.getIdDireccion()); 
		cliente.setIdContacto(clienteDetalle.getIdContacto());
		
		cliente.setNombre(clienteDetalle.getNombre());
		cliente.setApellidoMaterno(clienteDetalle.getApellidoPaterno());
		cliente.setApellidoMaterno(clienteDetalle.getApellidoMaterno());
		cliente.setEdad(clienteDetalle.getEdad());
		cliente.setSexo(clienteDetalle.getSexo());
		cliente.setRfc(clienteDetalle.getRfc());

		final Cliente updateCliente = clienteService.guardar(cliente);
		return ResponseEntity.ok(updateCliente);
	}

	@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.DELETE })
	@DeleteMapping("/deleteCliente/{id}")
	public Map<String, Boolean> deleteCliente(@PathVariable(value = "id") Long idCliente)
			throws ResourceNotFoundException {
		Cliente cliente = clienteService.obtenerPorId(idCliente)
				.orElseThrow(() -> new ResourceNotFoundException("No existe el cliente" + idCliente));

		clienteService.borrar(cliente.getIdCliente());
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	/* Fin de las operaciones de cliente **/
	
	
		
}