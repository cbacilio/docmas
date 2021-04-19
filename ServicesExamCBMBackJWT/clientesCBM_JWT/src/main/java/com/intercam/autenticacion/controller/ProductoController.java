package com.intercam.autenticacion.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
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
import com.intercam.autenticacion.entity.Producto;
import com.intercam.autenticacion.entity.Usuario;
import com.intercam.autenticacion.exception.ResourceNotFoundException;
import com.intercam.autenticacion.service.ProductoService;

import net.sf.jasperreports.engine.JRException;

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
	
    @GetMapping("/report/{format}")
    public String generateReport(@PathVariable String format) throws ResourceNotFoundException, FileNotFoundException, JRException {
        return productoService.exportReport(format);
    }

	

	/*@GetMapping("/exportPerfilPDF")
	public ResponseEntity<HttpStatus> getProfilesPDF(ServletRequest request, ServletResponse response)
			throws IOException, ClassNotFoundException {

		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		Usuario usuario = (Usuario) httpServletRequest.getSession().getAttribute(Const.USER_ATTRIBUTE);

		if (usuario != null) {
			List<Producto> bancaDigitals = new ArrayList<Producto>();
			bancaDigitals.addAll(usuario.getBancaDigital());

			List<BancaUsuario> bancaUsuarios = new ArrayList<BancaUsuario>();
			for (BancaDigital bancaDigital : bancaDigitals) {
				bancaUsuarios.addAll(bancaUsuarioService.findByIdBancaDigital(bancaDigital));
			}

			JasperPrint jasperPrint = pdfService.getReporteListaPerfiles(bancaUsuarios);
			byte[] pdfByteArray = JasperExportManager.exportReportToPdf(jasperPrint);
			response.setContentType("application/pdf;charset=windows-1252");

			response.setContentLength(pdfByteArray.length);
			javax.servlet.ServletOutputStream out = response.getOutputStream();
			out.write(pdfByteArray, 0, pdfByteArray.length);
			out.flush();
			out.close();

		} else {
			throw new BadCredentialsException(BDException.USUARIO_INCORRECTO);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
*/
	/* Fin de las operaciones de productos **/

}