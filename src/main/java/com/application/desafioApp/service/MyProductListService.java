package com.application.desafioApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.application.desafioApp.entities.MyProductList;
import com.application.desafioApp.repository.MyProductRepository;

@Service
public class MyProductListService {

	@Autowired
	private MyProductRepository myproduct;
	
	public void saveMyProducts(MyProductList product) {
		myproduct.save(product);
	}
	
	public List<MyProductList> getAllMyProducts(){
		return myproduct.findAll();
	}
	
	public void deleteById(int id) {
		myproduct.deleteById(id);
	}
}