package com.ciberfarma.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ciberfarma.model.Producto;

public interface IProductoRepository extends JpaRepository<Producto, String>{

}
