package com.intercam.autenticacion.service;


import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.io.FileNotFoundException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;

import com.intercam.autenticacion.entity.Producto;
import com.intercam.autenticacion.repository.ProductoRepository;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
@Transactional
public class ProductoService {

    @Autowired
    ProductoRepository productoRepository;

    public List<Producto> obtenerTodos(){
        List<Producto> lista = productoRepository.findAll();
        return lista;
    }

    public Optional<Producto> obtenerPorId(Long id){
        return productoRepository.findById(id);
    }

    public Producto guardar(Producto Producto){
    	return productoRepository.save(Producto);
    }

    public void borrar(Long id){
    	productoRepository.deleteById(id);
    }

   /* public boolean existePorNombre(String nc){
        return ProductoRepository.existsByNombreProducto(nc);
    }*/

    public boolean existePorId(Long id){
        return productoRepository.existsById(id);
    }
    
    public String exportReport(String reportFormat) throws JRException, FileNotFoundException  {
        String path = "C:\\DocumentosProyectos\\ReportesGenerados";
        List<Producto> lista = obtenerTodos();
        //load file and compile it
        File file = ResourceUtils.getFile("classpath:ReporteCliente.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(lista);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Constantino Bacilio Medel");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        System.out.println("333::"+lista.get(0).getDescripcion());
        if (reportFormat.equalsIgnoreCase("html")) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\productos.html");
        }
        if (reportFormat.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\productos.pdf");
        }

        return "report generated in path : " + path;
    }
}