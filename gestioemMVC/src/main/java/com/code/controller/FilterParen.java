package com.code.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.code.entities.User;
import com.code.services.UserServiceImp;

@Controller
@WebFilter(urlPatterns = { "/admin/*" })

public class FilterParen implements Filter{
	
	
	
	 public  void init(FilterConfig filterConfig) {
		 System.out.println("Good morning!");
	       
	   }
	   
	    public  void destroy() {
	    	System.out.println("LogFilter destroy!");
	   }
	   
	    
	    public  void doFilter(ServletRequest request, ServletResponse response,
	                         FilterChain filterChain)
	    throws IOException, ServletException {
	   
	    	
//	    	 HttpServletRequest request = (HttpServletRequest) request;
//	         HttpServletResponse response = (HttpServletResponse) response;
//	         String path = request.getServletPath();
	    	 HttpServletRequest httpRequest = (HttpServletRequest) request;
	    	 HttpServletResponse httpResponse = (HttpServletResponse) response;
	 
	    	HttpSession session = httpRequest.getSession(false);
	    	 
	        boolean isLoggedIn = (session != null && session.getAttribute("email") != null);
	 
           if (isLoggedIn ) {
//	         if (authenticate(request)) {
        	 filterChain.doFilter(request, response) ;
	             return;
           }else {
        	   System.out.println("not allowed");
        	   httpResponse.setContentType("text/html");
               PrintWriter out = response.getWriter();
               out.println("Sorry you don't have access!");
               
      	   
           }
         
	         
}
	    
}
