package com.application.desafioApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.application.desafioApp.service.MyProductListService;

@Controller
public class MyProductListController {
	
	@Autowired
	private MyProductListService service;
	
	@RequestMapping("/deleteMyList/{id}")
	public String deleteMyList(@PathVariable("id") int id) {
		service.deleteById(id);
		return "redirect:/my_products";
	}
}
