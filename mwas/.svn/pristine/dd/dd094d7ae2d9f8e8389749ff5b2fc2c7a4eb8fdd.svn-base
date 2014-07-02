/**
 * 
 */
package com.mwas.spring.controllers;

import javax.security.auth.callback.CallbackHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.mwas.authentication.PageLoginCallBackHandler;
import com.mwas.spring.beans.authentication.AuthorizationService;

/**
 * @author asus
 *
 */
public class HomePageController extends AbstractController {
	
	private AuthorizationService authService;
	
	public HomePageController(){
		
	}
	
	
	public void setAuthService(AuthorizationService authService){
		
		this.authService=authService;
	}


	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		ModelAndView modelAndView = null;
		String user= arg0.getParameter("user");
		String password=arg0.getParameter("password");
		CallbackHandler cbh= new PageLoginCallBackHandler(user,password);
		
		if (authService.authorize(cbh))
			modelAndView = new ModelAndView("test");
		
		return modelAndView;
	}

}
