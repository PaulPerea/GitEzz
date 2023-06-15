package com.ciberfarma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ciberfarma.model.Producto;
import com.ciberfarma.repository.ICategoriaRepository;
import com.ciberfarma.repository.IProductoRepository;
import com.ciberfarma.repository.IProveedorRepository;

@Controller
public class ProductoController {

	@Autowired
	private ICategoriaRepository repoCat;
	@Autowired
	private IProveedorRepository repoProv;
	@Autowired
	private IProductoRepository repoProd;
	
	@GetMapping("/cargar")
	public String abrirPagProd(Model model) {
		model.addAttribute("lstCategorias", repoCat.findAll());
		model.addAttribute("lstProveedores", repoProv.findAll());
		model.addAttribute("producto", new Producto());
		model.addAttribute("boton", "Registrar");
		return "crudproductos";
	}
	@GetMapping("/reportes")
	public String abrirPagRepor(Model model) {
		model.addAttribute("lstCategorias", repoCat.findAll());
		model.addAttribute("lstProveedores", repoProv.findAll());
		model.addAttribute("producto", new Producto());
		model.addAttribute("boton", "Reporte");
		return "reportes";
	}
	@GetMapping("/listado")
	public String muestraListadoModel(Model model) {
		model.addAttribute("lstProducto", repoProd.findAll());
		model.addAttribute("lstCategorias", repoCat.findAll());
		model.addAttribute("lstProveedores", repoProv.findAll());
		model.addAttribute("producto", new Producto());
		model.addAttribute("boton", "Registrar");
		return "crudproductos";
	}
	@GetMapping("/")
	public String abrirPagPri() {
		return "principal";
	}
	@PostMapping("/productos/guardar")
	public String guardarProducto(Model model,@ModelAttribute Producto producto) {
		try {
			repoProd.save(producto);
			model.addAttribute("mensaje","ok");
			model.addAttribute("clase","alert alert-success");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			model.addAttribute("mensaje", "Error");
			model.addAttribute("clase", "alert alert-danger");
		}
		model.addAttribute("boton", "Registrar");
		return "crudproductos";
	}
	@PostMapping("/buscar")
	public String buscarProducto(@RequestParam(name = "id_prod") String id_prod, Model model) {
			model.addAttribute("producto", repoProd.findById(id_prod));
			model.addAttribute("lstCategorias", repoCat.findAll());
			model.addAttribute("lstProveedores", repoProv.findAll());
			model.addAttribute("boton", "Actualizar");
		return "crudproductos";
	}
	@PostMapping("/eliminar")
	public String eliminarProducto(@ModelAttribute Producto producto, Model model) {
			repoProd.deleteById(producto.getId_prod());
			model.addAttribute("lstCategorias", repoCat.findAll());
			model.addAttribute("lstProveedores", repoProv.findAll());
			model.addAttribute("boton", "Registrar");
		return "crudproductos";
	}
}
