package com.ciberfarma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ciberfarma.model.Usuario;
import com.ciberfarma.repository.IUsuarioRepository;

@Controller
public class ProyectoController {	
	//controlador de cerrar sesion
	@GetMapping("/logout")
	public String login(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "login";
	}
	@Autowired
	private IUsuarioRepository repoUsu;
	//controlador para leer los datos del form login
	@PostMapping ("/login")
	public String acceso(@ModelAttribute Usuario usuario, Model model) {
		System.out.print(usuario);
		//validar con la bd -->obtener aegun los param
		Usuario u =repoUsu.findByCorreoAndClave(usuario.getCorreo(), usuario.getClave());
		if(u!=null) {
			return "principal";
		}
		else {
			model.addAttribute("mensaje","Usuario o clave incorrecto");
			model.addAttribute("clave","alert alert-danger");
			return "login";
		}
				
	}
}
