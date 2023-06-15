package com.ciberfarma.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ciberfarma.model.Categoria;

public interface ICategoriaRepository extends JpaRepository<Categoria, Integer>{

}
