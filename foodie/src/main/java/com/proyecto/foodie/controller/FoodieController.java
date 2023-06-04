package com.proyecto.foodie.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.proyecto.foodie.form.LoginForm;
import com.proyecto.foodie.model.Platos;
import com.proyecto.foodie.repository.AdminRepository;
import com.proyecto.foodie.repository.ClienteRepository;
import com.proyecto.foodie.repository.PlatosRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class FoodieController {
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private PlatosRepository platosRepository;
	
	@GetMapping("/")
	public String index(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		Iterable<Platos> itPlatos = platosRepository.findAll();
	    List<Platos> listaPlatos = new ArrayList<>();
	    itPlatos.forEach(listaPlatos::add);
	    model.addAttribute("listaPlatos", listaPlatos);
	    
		return "index";
	}
	
	@GetMapping("/login")
	public String login(LoginForm loginForm) {
		return "login";
	}
}
