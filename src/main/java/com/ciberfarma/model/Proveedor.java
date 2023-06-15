package com.ciberfarma.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="tb_proveedor")
@Data
public class Proveedor {
@Id
private int idproveedor;
private String nombre_rs;
private String telefono;
private String email;
}
