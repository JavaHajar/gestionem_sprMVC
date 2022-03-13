
package com.code.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.code.dao.UserDao;
import com.code.entities.Role;
import com.code.entities.User;
import com.code.services.RoleService;
import com.code.services.UserService;

@Controller
@SessionAttributes("users")
public class AdminController {

 @Autowired
 private UserService userService;
 
 @Autowired
 private RoleService roleService;


   
 @PostMapping(value = "/login")
 public String authentication (@Valid User user, HttpSession session, BindingResult result, ModelMap map, Model model) throws Exception{
	 String email =user.getEmail();
	 String password = user.getPassword();
	if( userService.islogged(email, password)) {
        session.setAttribute("email", email);
        session.setAttribute("password", password);
		return "redirect:/admin/home";
	} else  {
		model.addAttribute("user", user);
		 model.addAttribute("denied", "Warning, Email ou mot de passe est incorrect!");
		 return "login";	 
    }
	
 }

 @RequestMapping("/admin/logout")
	public String logout(HttpSession session) {
	 session.removeAttribute("email"); 
	 session.removeAttribute("password");
	return "redirect:/";
 }
 
	@RequestMapping("/admin/new")
    public String showAdd(Model model, User user) {
		model.addAttribute("user", user);
		model.addAttribute("roles", roleService.findAll());
        return "AddUser";
    }
	
	@PostMapping(value = "/admin/insert")
	public String AddUser(@Valid @ModelAttribute("user") User user, @RequestParam int rol_id, BindingResult result) {
		
		if (result.hasErrors()) {
            return "AddUser";
        }
		userService.save(user, rol_id);
		return "redirect:/admin/home";
    }
	
	@GetMapping("/admin/edit/{id}")
    public String editForm(@PathVariable("id") int id, Model model) {
        User user = userService.findId(id);
        model.addAttribute("roles", roleService.findAll());
        model.addAttribute("user", user);
        return "EditUser";
    }
	
	@PostMapping("/admin/update")
    public String updateStudent( @Valid User user,@RequestParam int rol_id, BindingResult result) {
        userService.update(user,rol_id);
        return "redirect:/admin/home";
    }
	@RequestMapping("/admin/deletuser")
	   public String deleteUser(Model model, @RequestParam("id") int id) {
	           this.userService.delete(id);
	       return "redirect:/admin/home";
	   }
	
	@RequestMapping("/admin/home")
	public String home(Model model) {
		   model.addAttribute("users", userService.finAll());
		  return "home";}
}
