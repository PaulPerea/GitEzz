package com.ciberfarma.controller;

import java.io.OutputStream;
import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ciberfarma.model.Producto;

import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@Controller
public class ReporteController {
	
	@Autowired
	private DataSource dataSource; // javax.sql
	@Autowired
	private ResourceLoader resourceLoader; // core.io

	@GetMapping("/productos/listadopdf")
	public void reporteProductos(HttpServletResponse response) {

		// response.setHeader("Content-Disposition", "attachment;
		// filename=\"reporte.pdf\";"); //para que el reporte se descargue en un archivo

		response.setHeader("Content-Disposition", "inline;"); // para que el pdf se muestre en pantalla
		response.setContentType("application/pdf"); // tipo de contenido
		try {
			//obtener el recurso a utilizar ->jasper         -nombre del jasper a poner y si esta dentro de la carpeta-
			String ru = resourceLoader.getResource("classpath:reportes/reporte2.jasper").getURI().getPath();
			//aqui se combina el jasper + data / OJO!!!! null -> la conexion no iene parametros
			JasperPrint jasperPrint = JasperFillManager.fillReport(ru, null, dataSource.getConnection());
			//genera un archivo temporal
			OutputStream outStream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@GetMapping("/pdf/stock")
	public void reporteStock(HttpServletResponse response) {

		// response.setHeader("Content-Disposition", "attachment;
		// filename=\"reporte.pdf\";"); //para que el reporte se descargue en un archivo

		response.setHeader("Content-Disposition", "inline;"); // para que el pdf se muestre en pantalla
		response.setContentType("application/pdf"); // tipo de contenido
		try {
			//obtener el recurso a utilizar ->jasper         -nombre del jasper a poner y si esta dentro de la carpeta-
			String ru = resourceLoader.getResource("classpath:reportes/reporte3_grafico.jasper").getURI().getPath();
			//aqui se combina el jasper + data / OJO!!!! null -> la conexion no iene parametros
			JasperPrint jasperPrint = JasperFillManager.fillReport(ru, null, dataSource.getConnection());
			//genera un archivo temporal
			OutputStream outStream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	//con filtro
	@PostMapping("/reportes")
	public void reportefiltro(@ModelAttribute Producto producto, HttpServletResponse response) {

		

		response.setHeader("Content-Disposition", "inline;"); // para que el pdf se muestre en pantalla
		response.setContentType("application/pdf"); // tipo de contenido
		try {
			//
			String ru = resourceLoader.getResource("classpath:reportes/reporte4_filtro.jasper").getURI().getPath();
			HashMap parametros = new HashMap();
			parametros.put("categoria", producto.getObjCategoria());
			//
			JasperPrint jasperPrint = JasperFillManager.fillReport(ru, parametros, dataSource.getConnection());
			//
			OutputStream outStream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
