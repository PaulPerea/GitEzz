package com.ciberfarma.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ciberfarma.model.Usuario;

public interface IUsuarioRepository extends JpaRepository< Usuario, Integer>{
	//metodo que busque x usuario y clave 
	public Usuario findByCorreoAndClave(String correo, String clave);
}
