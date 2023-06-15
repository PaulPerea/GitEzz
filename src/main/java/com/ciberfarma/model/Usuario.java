package com.ciberfarma.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="tb_usuarios")
@Data
public class Usuario {
	@Id
	private int cod_usua;
	private String nom_usua;
	private String ape_usua;
	@Column(name="usr_usua")
	private String correo;
	@Column(name="cla_usua")
	private String clave;
	private String fna_usua;
	private int idtipo;
	private int est_usua;
}
