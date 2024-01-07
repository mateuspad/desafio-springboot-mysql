package com.application.desafioApp.entities;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Table(name="MyProducts")
public class MyProductList {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nomeDoProduto;
	private String descricaoDoProduto;
	private double precoDoProduto;
	
	public MyProductList() {
		super();
	}

	public MyProductList(int id, String nomeDoProduto, String descricaoDoProduto, double precoDoProduto) {
		super();
		this.id = id;
		this.nomeDoProduto = nomeDoProduto;
		this.descricaoDoProduto = descricaoDoProduto;
		this.precoDoProduto = precoDoProduto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeDoProduto() {
		return nomeDoProduto;
	}

	public void setNomeDoProduto(String nomeDoProduto) {
		this.nomeDoProduto = nomeDoProduto;
	}

	public String getDescricaoDoProduto() {
		return descricaoDoProduto;
	}

	public void setDescricaoDoProduto(String descricaoDoProduto) {
		this.descricaoDoProduto = descricaoDoProduto;
	}

	public double getPrecoDoProduto() {
		return precoDoProduto;
	}

	public void setPrecoDoProduto(double precoDoProduto) {
		this.precoDoProduto = precoDoProduto;
	}
}
