package com.proyecto.foodie.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
			session.setAttribute("id", loginUser.getIdUsuario());
//			if(login.getRol().getRol().equalsIgnoreCase("admin")) {
//				return "admin";
//			}else{
//				return "user";
//			}
//			
			System.out.println("entras como user");
			return "redirect:/";
		} else if (loginCliente != null && loginCliente.getContrasena().equals(loginForm.getContrasena())) {
			session.setAttribute("id", loginCliente.getIdCliente());
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
			session.setAttribute("error", "Correo o contraseña incorrectos");
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
	
	@GetMapping("/perfil")
	public String perfil(SignupForm signupForm, HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		Cliente cliente = clienteRepository.findById((Integer) session.getAttribute("id")).orElse(null);
		
		System.out.println("patata" + cliente.toString());
		model.addAttribute("cliente", cliente);
		return "perfil";
	}
	
	@PostMapping(path="/actualizarPerfil")
	public String actualizarPerfil(@ModelAttribute("signupForm") @Valid SignupForm signupForm, HttpServletRequest request, Model model, RedirectAttributes redirectAttributes) {
		HttpSession session = request.getSession();
		
		Cliente cliente = clienteRepository.findById((Integer) session.getAttribute("id")).orElse(null);
		
		cliente.setNombreCliente(signupForm.getNombreCliente());
        cliente.setApellidosCliente(signupForm.getApellidosCliente());
        cliente.setTelefonoCliente(signupForm.getTelefonoCliente());
        cliente.setCorreoElectronico(signupForm.getCorreoElectronico());
        cliente.setContrasena(signupForm.getContrasena());
        cliente.setTarjetaCredito(signupForm.getTarjetaCredito());
        
		clienteRepository.save(cliente);
		
		redirectAttributes.addFlashAttribute("mensaje", "Los cambios se guardaron correctamente.");
		model.addAttribute("loginForm", new LoginForm());
	    return "redirect:/perfil";
	}
}
