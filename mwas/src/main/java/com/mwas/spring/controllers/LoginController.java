/**
 * 
 */
package com.mwas.spring.controllers;

import javax.security.auth.callback.CallbackHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.ParameterMethodNameResolver;

import com.mwas.authentication.FMSession;
import com.mwas.authentication.PageLoginCallBackHandler;
import com.mwas.spring.beans.authentication.AuthorizationService;

/**
 * @author asus
 *
 */
@Controller
@SessionAttributes({"FMSession"})
public class LoginController {

	/**
	 * 
	 */
	private ParameterMethodNameResolver methodNameResolver;
	
	@Autowired
	private AuthorizationService authService;
	
	//private FMSession usersession=null;   //Later use a proper UserSession object ( subject,principal )

	private FMSession userSession=null;
	private ModelAndView homepageMV = null;
	private ModelAndView loginpageMV=null;
	
	public LoginController() 
	{
		homepageMV = new ModelAndView("datatable");
		loginpageMV = new ModelAndView("/login/login");
	}
	
	/**
	 * @param delegate
	 */
	/*public LoginController(Object delegate) {
		super(delegate);
		// TODO Auto-generated constructor stub
	}*/
	@RequestMapping(value="/home.htm" , method= RequestMethod.GET,params="submit=signIn")
	public ModelAndView signIn(HttpServletRequest arg0,
			HttpSession session) throws Exception 
	{
			// TODO Auto-generated method stub
			ModelAndView modelAndView = null;
			String user= arg0.getParameter("user");
			String password=arg0.getParameter("password");
			CallbackHandler cbh= new PageLoginCallBackHandler(user,password);
			
			//if (authService.authorize(cbh))
			if(authService.authorize(cbh) !=null)
			{
				userSession = FMSession.getSessionInstance();
				//homepageMV.addObject("FMSession", userSession);
				session.setAttribute("FMSession", userSession);
				modelAndView = homepageMV;
			}
			
			return modelAndView;
		
	 }
	
	@RequestMapping(value="/forgotPassword.htm" , method= RequestMethod.GET,params="submit=forgetPassword")
	public ModelAndView forgetPassword(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception
	{
		return null;
		
	}
	
	/// Put FMSession object in HTTPSession   ????????
	@RequestMapping(value="/home.htm" , method=RequestMethod.GET,params="submit=home")
	public ModelAndView home(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception
	{
		System.out.println("Enter home method");
		ModelAndView modelAndView = null;
		
		if (userSession !=null && userSession.isSessionLogin())
		{	
			userSession.setHomepagehit(userSession.getHomepagehit()+1);
			System.out.println("Homepagehits "+userSession.getHomepagehit());
			System.out.println("SecurityToken "+userSession.getSecurityToken());
			//homepageMV.addObject("FMSession", userSession);
			modelAndView=homepageMV;
			
		}
		else
			modelAndView=loginpageMV;
		
		System.out.println("Exit home method");
		return modelAndView;
	
	}
	
	@RequestMapping(value="/home.htm" , method= RequestMethod.POST,params="submit=signout")
	public ModelAndView logout(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception
	{
		System.out.println("Logout method");
		if (userSession !=null && userSession.isSessionLogin())
		{
			userSession.setSessionLogin(false);
			System.out.println("SecurityToken "+userSession.getSecurityToken());
			userSession = null;
			FMSession.destroy(); ////  destroy this
			arg0.getSession().invalidate();
		}

		return loginpageMV;
		
			
	}
	
	/**
	 * @param methodNameResolver the methodNameResolver to set
	 */
	public void setMethodNameResolver(ParameterMethodNameResolver methodNameResolver) {
		this.methodNameResolver = methodNameResolver;
	}
		
}
