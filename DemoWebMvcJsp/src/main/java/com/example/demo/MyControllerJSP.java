package com.example.demo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.business.Product;
import com.example.demo.business.ProductRepository;


@Controller
public class MyControllerJSP{
	
	@Autowired
	ProductRepository repo;

    @RequestMapping("/")
    public String handler(Model model) {
        model.addAttribute("msg", "Spring Boot web app, JAR packaging, JSP views");
        return "myView";
    }
    
    @RequestMapping("/productsnotmvc")
    public String p_not_mvchandler() {
        return "productsnotmvc";
    }
    
    @RequestMapping("/products/{page}")
    public ModelAndView p_mvchandler(HttpServletRequest request, @PathVariable int page) {
    	ModelAndView result = new ModelAndView();
		List<Product> temp = repo.getProducts();
		List<Product> products;
		int[] pages;
		int start = page * 10 - 10;
		if(start + 10 < temp.size()){
			products = temp.subList(start, start + 10);
		}
		else{
			products = temp.subList(start, temp.size());
		}
		int numPages = temp.size() / 10 + 1;
		pages = new int[numPages];
		for(int i = 0; i < numPages; i++){
			pages[i] = i + 1;
		}
		result.addObject("products",products);
		result.addObject("pages",pages);
		result.setViewName("products");
		return result;
    }
    
    @RequestMapping("/new")
    public String p_mvcnewhandler(Model model) {
    	model.addAttribute("categories", repo.getCategories());  
    	return "newproduct";
    }
    
    @RequestMapping("/add")
    public String p_mvcaddhandler(HttpServletRequest request,Model model) {
    	Product p = new Product(Integer.parseInt(request.getParameter("id")),
    			request.getParameter("name"),
    			Double.parseDouble(request.getParameter("price")),
    			Integer.parseInt(request.getParameter("categoryid")),
    			"");
    	int rows = repo.addProduct(p);
    	model.addAttribute("msg", rows + " product added ");  
    	return "myView";
    }
    
}
