package com.ciberfarma.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="tb_productos")
@Data
public class Producto {
	@Id
	private String id_prod;
	private String des_prod;
	private int stk_prod;
	private double pre_prod;
	private int idcategoria;
	private String est_prod;
	private int idproveedor;
	
	@ManyToOne
	@JoinColumn(name = "idcategoria", insertable = false, updatable = false)
	private Categoria objCategoria;
	@ManyToOne
	@JoinColumn(name = "idproveedor", insertable = false, updatable = false)
	private Proveedor objProveedor;
}
