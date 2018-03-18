package com.telusko;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.telusko.Bean.UserBean;

import com.telusko.service.LoginService;


@Controller
public class LoginController {

	@RequestMapping("/login")
	public ModelAndView add(@RequestParam("username") String username, HttpServletRequest request,@RequestParam("password") String password, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException{
		

	     UserBean userbean = new UserBean();
	     userbean.setUserName(username);
	     userbean.setPassword(password);
		 LoginService loginservice = new LoginService();
		 Boolean validuser = loginservice.validateUser(userbean).isValid();
		 
		 ModelAndView mv = null; 
		 if (validuser)
	     {	          
	          HttpSession session = request.getSession(true);	    
	          session.setAttribute("currentSessionUsername",request.getParameter("username")); 
	          mv = new ModelAndView();
			  mv.setViewName("display.jsp");
			  mv.addObject("username",userbean.getUsername());
			  return mv;   		
	     }
		        
/*	     else{ 
	          try {
				response.sendRedirect("invalidLogin.jsp");
			} catch (IOException e) {

				e.printStackTrace();
			} */
		    return mv;
	}
	
}
