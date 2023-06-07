package com.proyecto.foodie.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.proyecto.foodie.form.LoginForm;
import com.proyecto.foodie.form.SignupForm;
import com.proyecto.foodie.model.Cliente;
import com.proyecto.foodie.model.Platos;
import com.proyecto.foodie.model.Usuarios;
import com.proyecto.foodie.repository.AdminRepository;
import com.proyecto.foodie.repository.ClienteRepository;
import com.proyecto.foodie.repository.EmpleadoRepository;
import com.proyecto.foodie.repository.PlatosRepository;
import com.proyecto.foodie.repository.UsuariosRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class FoodieController {
	
	@Autowired
	private UsuariosRepository usuariosRepository;
	
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
	
	@PostMapping(path="/login")
	public String checkLoginInfo(@ModelAttribute("loginForm") LoginForm loginForm, HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		Usuarios loginUser = usuariosRepository.findByCorreoElectronico(loginForm.getCorreoElectronico());
		Cliente loginCliente = clienteRepository.findByCorreoElectronico(loginForm.getCorreoElectronico());
		
		if (loginUser != null && loginUser.getContrasena().equals(loginForm.getContrasena())) {
			session.setAttribute("correo", loginForm.getCorreoElectronico());
			session.setAttribute("dni", loginUser.getDniUsuario());
//			if(login.getRol().getRol().equalsIgnoreCase("admin")) {
//				return "admin";
//			}else{
//				return "user";
//			}
//			
			System.out.println("entras como user");
			return "redirect:/";
		} else if (loginCliente != null && loginCliente.getContrasena().equals(loginForm.getContrasena())) {
			session.setAttribute("correo", loginForm.getCorreoElectronico());
			session.setAttribute("dni", loginCliente.getDniCliente());
//			if(login.getRol().getRol().equalsIgnoreCase("admin")) {
//				return "admin";
//			}else{
//				return "user";
//			}
//			
			System.out.println("entras como cliente");
			return "redirect:/";
		} else {
			System.out.println("peta");
			session.setAttribute("error", "Usuario o contraseña incorrectos");
			return "redirect:/login";
		}
	}
	
	@GetMapping("/signup")
	public String signup(SignupForm signupForm) {
		return "signup";
	}
	
	@PostMapping(path="/signup")
	public String checkSignupInfo(@ModelAttribute("signupForm") @Valid SignupForm signupForm, BindingResult bindingResult, HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		
		if(bindingResult.hasErrors()) {
	        return "signup";
	    }
		
		Cliente cliente = new Cliente(signupForm.getDniCliente(), signupForm.getNombreCliente(), signupForm.getApellidosCliente(), signupForm.getTelefonoCliente(), signupForm.getCorreoElectronico(), signupForm.getContrasena(), signupForm.getTarjetaCredito());
		clienteRepository.save(cliente);
		
		model.addAttribute("loginForm", new LoginForm());
	    session.setAttribute("cuenta", "Cuenta creada éxitosamente");
	    return "redirect:/login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
	    HttpSession session = request.getSession();
	    session.invalidate();
	    return "redirect:/";
	}
}
