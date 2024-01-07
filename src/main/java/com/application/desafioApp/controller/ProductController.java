package com.application.desafioApp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.application.desafioApp.entities.MyProductList;
import com.application.desafioApp.entities.Product;
import com.application.desafioApp.service.MyProductListService;
import com.application.desafioApp.service.ProductService;


@Controller
public class ProductController {

	@Autowired
	private ProductService service;
	
	@Autowired
	private MyProductListService myProductService;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/product_register")
	public String productRegister() {
		return "productRegister";
	}
	
	@GetMapping("/available_products")
	public ModelAndView getAllProducts() {
		List<Product>list = service.getAllProduct();	
		return new ModelAndView("productList","product",list);
	}
	
	@PostMapping("/save")
	public String addProducts(@ModelAttribute Product p) {
		service.save(p);
		return "redirect:/available_products";
	}
	
	@GetMapping("/my_products")
	public String getMyProducts(Model model){
		List<MyProductList>list=myProductService.getAllMyProducts();
		model.addAttribute("product",list);
		return "myProducts";
	}
	
	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id) {
		Product p=service.getProductById(id);
		MyProductList mp=new MyProductList(p.getId(),p.getNomeDoProduto(),p.getDescricaoDoProduto(),p.getPrecoDoProduto());
		myProductService.saveMyProducts(mp);
		return "redirect:/my_products";
	}
	
	@RequestMapping("/editProduct/{id}")
	public String editProduct(@PathVariable("id") int id,Model model) {
		Product p=service.getProductById(id);
		model.addAttribute("product",p);
		return "productEdit";
	}
	@RequestMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable("id")int id) {
		service.deleteById(id);
		return "redirect:/available_products";
	}
}
