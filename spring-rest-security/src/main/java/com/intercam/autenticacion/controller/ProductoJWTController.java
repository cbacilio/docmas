//package com.intercam.autenticacion.controller;
//
//
//import java.util.List;
//
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.intercam.autenticacion.dto.Mensaje;
//import com.intercam.autenticacion.entity.ProductoJWT;
//import com.intercam.autenticacion.service.ProductoService;
//import io.swagger.annotations.Api;
//
//@RestController
//@RequestMapping("/api/productos")
//@CrossOrigin(origins = "http://localhost:4200")
//@Api(value = "Users microservice productos")
//public class ProductoJWTController {
//
//    @Autowired
//    ProductoService productoService;
//
//    @GetMapping("/swagger")
//    public String home() {
//	return "redirect:/swagger-ui.html";
//    }
//    
//    @GetMapping("/lista")
//    public ResponseEntity<List<ProductoJWT>> getLista(){
//        List<ProductoJWT> lista = productoService.obtenerTodos();
//        return new ResponseEntity<List<ProductoJWT>>(lista, HttpStatus.OK);
//    }
//
//    @GetMapping("/detalle/{id}")
//    public ResponseEntity<ProductoJWT> getOne(@PathVariable Long id){
//        if(!productoService.existePorId(id))
//            return new ResponseEntity(new Mensaje("no existe ese producto"), HttpStatus.NOT_FOUND);
//        ProductoJWT producto = productoService.obtenerPorId(id).get();
//        return new ResponseEntity<ProductoJWT>(producto, HttpStatus.OK);
//    }
//
//    /*@PostMapping("nuevo")
//    @PreAuthorize("hasRole('ADMIN')")
//    public ResponseEntity<?> create(@RequestBody ProductoJWT producto){
//        if(StringUtils.isBlank(producto.getNombreProducto()))
//            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
//        if((Integer)producto.getPrecio() == null || producto.getPrecio()==0)
//            return new ResponseEntity(new Mensaje("el precio es obligatorio"), HttpStatus.BAD_REQUEST);
//        if(productoService.existePorNombre(producto.getNombreProducto()))
//            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
//        productoService.guardar(producto);
//        return new ResponseEntity(new Mensaje("producto guardado"), HttpStatus.CREATED);
//    }
//
//    @PutMapping("/actualizar/{id}")
//    @PreAuthorize("hasRole('ADMIN')")
//    public ResponseEntity<?> update(@RequestBody ProductoJWT producto, @PathVariable("id") Long id){
//        if(!productoService.existePorId(id))
//            return new ResponseEntity(new Mensaje("no existe ese producto"), HttpStatus.NOT_FOUND);
//        if(StringUtils.isBlank(producto.getNombreProducto()))
//            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
//        if((Integer)producto.getPrecio() == null || producto.getPrecio()==0)
//            return new ResponseEntity(new Mensaje("el precio es obligatorio"), HttpStatus.BAD_REQUEST);
//        if(productoService.existePorNombre(producto.getNombreProducto()) &&
//                productoService.obtenerPorNombre(producto.getNombreProducto()).get().getId() != id)
//            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
//        ProductoJWT prodUpdate = productoService.obtenerPorId(id).get();
//        prodUpdate.setNombreProducto(producto.getNombreProducto());
//        prodUpdate.setPrecio(producto.getPrecio());
//        productoService.guardar(prodUpdate);
//        return new ResponseEntity(new Mensaje("producto actualizado"), HttpStatus.CREATED);
//    }
//
//    @DeleteMapping("/borrar/{id}")
//    @PreAuthorize("hasRole('ADMIN')")
//    public ResponseEntity<?> delete(@PathVariable Long id){
//        if(!productoService.existePorId(id))
//            return new ResponseEntity(new Mensaje("no existe ese producto"), HttpStatus.NOT_FOUND);
//        productoService.borrar(id);
//        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
//    }
//    */
//}
