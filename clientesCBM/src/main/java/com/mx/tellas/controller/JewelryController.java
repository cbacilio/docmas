package com.mx.tellas.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.mx.tellas.model.entitys.Abono;
import com.mx.tellas.model.entitys.Cliente;
import com.mx.tellas.model.entitys.Contacto;
import com.mx.tellas.model.entitys.Direccion;
import com.mx.tellas.model.entitys.Producto;
import com.mx.tellas.model.entitys.Venta;
import com.mx.tellas.model.exception.ResourceNotFoundException;
import com.mx.tellas.model.repository.AbonoRepository;
import com.mx.tellas.model.repository.ClienteRepository;
import com.mx.tellas.model.repository.ContactoRepository;
import com.mx.tellas.model.repository.DireccionRepository;
import com.mx.tellas.model.repository.ProductoRepository;
import com.mx.tellas.model.repository.VentaRepository;

/**
 * Clase que expone los servicios REST de ventas Tellas Company
 * 
 * @author CBM
 *
 */
@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })
@RestController
@RequestMapping(path = "/joyeria")
public class JewelryController {

	@Autowired
	private VentaRepository ventaRepository;

	@Autowired
	private ProductoRepository productoRepository;

	@Autowired
	private DireccionRepository direccionRepository;

	@Autowired
	private ContactoRepository contactoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private AbonoRepository abonoRepository;

	/**
	 * Operaciones abono
	 */
	@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.GET })
	@GetMapping(path = "/listarAbono")
	public List<Abono> getAllAbono() {
		return abonoRepository.findAll();
	}

	@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.POST })
	@PostMapping("/addAbono")
	public Abono createAbono(@Valid @RequestBody Abono abono) {
		return abonoRepository.save(abono);
	}

	@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.PUT })
	@PutMapping("/updateAbono/{id}")
	public ResponseEntity<Abono> updateAbono(@PathVariable(value = "id") Long idAbono,
			@Valid @RequestBody Abono abonoDetalle) throws ResourceNotFoundException {
		Abono abono = abonoRepository.findById(idAbono)
				.orElseThrow(() -> new ResourceNotFoundException("No existe el abono" + idAbono));

		abono.setMonto(abonoDetalle.getMonto());
		abono.setFecha(abonoDetalle.getFecha()); 

		final Abono updateAbono = abonoRepository.save(abono);
		
		return ResponseEntity.ok(updateAbono);
	}

	@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.DELETE })
	@DeleteMapping("/deleteAbono/{id}")
	public Map<String, Boolean> deleteAbono(@PathVariable(value = "id") Long IdAbono)
			throws ResourceNotFoundException {
		Abono abono = abonoRepository.findById(IdAbono)
				.orElseThrow(() -> new ResourceNotFoundException("No existe el abono" + IdAbono));

		abonoRepository.delete(abono);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	/* Fin de las operaciones de abono **/
	
	/**
	 * Operaciones cliente
	 */
	@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.GET })
	@GetMapping(path = "/listarCliente")
	public List<Cliente> getAllCliente() {
		return clienteRepository.findAll();
	}


	@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.POST })
	@PostMapping("/addCliente")
	public Cliente createCliente(@Valid @RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.PUT })
	@PutMapping("/updateCliente/{id}")
	public ResponseEntity<Cliente> updateCliente(@PathVariable(value = "id") Long idCliente,
			@Valid @RequestBody Cliente clienteDetalle) throws ResourceNotFoundException {
		Cliente cliente = clienteRepository.findById(idCliente)
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

		final Cliente updateCliente = clienteRepository.save(cliente);
		return ResponseEntity.ok(updateCliente);
	}

	@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.DELETE })
	@DeleteMapping("/deleteCliente/{id}")
	public Map<String, Boolean> deleteCliente(@PathVariable(value = "id") Long idCliente)
			throws ResourceNotFoundException {
		Cliente cliente = clienteRepository.findById(idCliente)
				.orElseThrow(() -> new ResourceNotFoundException("No existe el cliente" + idCliente));

		clienteRepository.delete(cliente);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	/* Fin de las operaciones de cliente **/
	
	
	
	/**
	 * Operaciones contacto
	 */
	@CrossOrigin(origins = "http://localhost:8080", methods = { RequestMethod.GET })
	@GetMapping(path = "/listarContacto")
	public List<Contacto> getAllContacto() {
		return contactoRepository.findAll();
	}

	@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.POST })
	@PostMapping("/addContacto"
			+ "")
	public Contacto createContacto(@Valid @RequestBody Contacto contacto) {
		return contactoRepository.save(contacto);
	}

	@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.PUT })
	@PutMapping("/updateContacto/{id}")
	public ResponseEntity<Contacto> updateContacto(@PathVariable(value = "id") Long idContacto,
			@Valid @RequestBody Contacto contactoDetalle) throws ResourceNotFoundException {
		Contacto contacto = contactoRepository.findById(idContacto)
				.orElseThrow(() -> new ResourceNotFoundException("No existe el contacto" + idContacto));

		contacto.setIdCliente(contactoDetalle.getIdCliente());
		contacto.setEmail(contactoDetalle.getEmail());
		contacto.setTelefono(contactoDetalle.getTelefono());	
		final Contacto updateContacto = contactoRepository.save(contacto);
		return ResponseEntity.ok(updateContacto);
	}

	@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.DELETE })
	@DeleteMapping("/deleteContacto/{id}")
	public Map<String, Boolean> deleteContacto(@PathVariable(value = "id") Long idContacto)
			throws ResourceNotFoundException {
		Contacto contacto = contactoRepository.findById(idContacto)
				.orElseThrow(() -> new ResourceNotFoundException("No existe el contacto" + idContacto));

		contactoRepository.delete(contacto);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	/* Fin de las operaciones de contacto **/

	
	
	/**
	 * Operaciones direccion
	 */
	@CrossOrigin(origins = "http://localhost:8080", methods = { RequestMethod.GET })
	@GetMapping(path = "/listarDireccion")
	public List<Direccion> getAllDireccion() {
		return direccionRepository.findAll();
	}


	@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.POST })
	@PostMapping("/addDireccion"
			+ "")
	public Direccion createDireccion(@Valid @RequestBody Direccion direccion) {
		return direccionRepository.save(direccion);
	}

	@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.PUT })
	@PutMapping("/updateDireccion/{id}")
	public ResponseEntity<Direccion> updateDireccion(@PathVariable(value = "id") Long idDireccion,
			@Valid @RequestBody Direccion direccionDetalle) throws ResourceNotFoundException {
		Direccion direccion = direccionRepository.findById(idDireccion)
				.orElseThrow(() -> new ResourceNotFoundException("No existe la direccion" + idDireccion));

		
		direccion.setIdCliente(direccionDetalle.getIdCliente());
		direccion.setCalle(direccionDetalle.getCalle());
		direccion.setColonia(direccionDetalle.getColonia());
		direccion.setMunicipio(direccionDetalle.getMunicipio());
		direccion.setEstado(direccionDetalle.getEstado());
		direccion.setCp(direccionDetalle.getCp());
		
		
		final Direccion updateDireccion = direccionRepository.save(direccion);
		return ResponseEntity.ok(updateDireccion);
	}

	@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.DELETE })
	@DeleteMapping("/deleteDireccion/{id}")
	public Map<String, Boolean> deleteDireccion(@PathVariable(value = "id") Long idDireccion)
			throws ResourceNotFoundException {
		Direccion direccion = direccionRepository.findById(idDireccion)
				.orElseThrow(() -> new ResourceNotFoundException("No existe la direccion" + idDireccion));

		direccionRepository.delete(direccion);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	/* Fin de las operaciones de direccion **/

	
	/**
	 * Operaciones producto
	 */
	@CrossOrigin(origins = "http://localhost:8080", methods = { RequestMethod.GET })
	@GetMapping(path = "/listarProducto")
	public List<Producto> getAllProducto() {
		return productoRepository.findAll();
	}



	@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.POST })
	@PostMapping("/addProducto"
			+ "")
	public Producto createProducto(@Valid @RequestBody Producto producto) {
		return productoRepository.save(producto);
	}

	@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.PUT })
	@PutMapping("/updateProducto/{id}")
	public ResponseEntity<Producto> updateProducto(@PathVariable(value = "id") Long idProducto,
			@Valid @RequestBody Producto productoDetalle) throws ResourceNotFoundException {
		Producto producto = productoRepository.findById(idProducto)
				.orElseThrow(() -> new ResourceNotFoundException("No existe el producto" + idProducto));

		
		producto.setDescripcion(productoDetalle.getDescripcion());

		
		final Producto updateProducto = productoRepository.save(producto);
		return ResponseEntity.ok(updateProducto);
	}

	@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.DELETE })
	@DeleteMapping("/deleteProducto/{id}")
	public Map<String, Boolean> deleteProducto(@PathVariable(value = "id") Long idProducto)
			throws ResourceNotFoundException {
		Producto producto = productoRepository.findById(idProducto)
				.orElseThrow(() -> new ResourceNotFoundException("No existe el producto" + idProducto));

		productoRepository.delete(producto);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	/* Fin de las operaciones de productos **/
	


	
	/**
	 * Operaciones venta
	 */
	@CrossOrigin(origins = "http://localhost:8080", methods = { RequestMethod.GET })
	@GetMapping(path = "/listarVenta")
	public List<Venta> getAllVenta() {
		return ventaRepository.findAll();
	}



	@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.POST })
	@PostMapping("/addVenta"
			+ "")
	public Venta createProducto(@Valid @RequestBody Venta venta) {
		return ventaRepository.save(venta);
	}

	@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.PUT })
	@PutMapping("/updateVenta/{id}")
	public ResponseEntity<Venta> updateVenta(@PathVariable(value = "id") Long idVenta,
			@Valid @RequestBody Venta ventaDetalle) throws ResourceNotFoundException {
		Venta venta = ventaRepository.findById(idVenta)
				.orElseThrow(() -> new ResourceNotFoundException("No existe la venta" + idVenta));

		
		venta.setDescripcion(ventaDetalle.getDescripcion());

		
		final Venta updateVenta = ventaRepository.save(venta);
		return ResponseEntity.ok(updateVenta);
	}

	@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.DELETE })
	@DeleteMapping("/deleteVenta/{id}")
	public Map<String, Boolean> deleteVenta(@PathVariable(value = "id") Long idVenta)
			throws ResourceNotFoundException {
		Venta venta = ventaRepository.findById(idVenta)
				.orElseThrow(() -> new ResourceNotFoundException("No existe la venta" + idVenta));

		ventaRepository.delete(venta);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	/* Fin de las operaciones de venta **/
	






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