/**
 * 
 */
package com.mwas.spring.controllers;

import java.util.List;

import javax.security.auth.callback.CallbackHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mwas.authentication.SPACESession;
import com.mwas.authentication.SPACESessionImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.ParameterMethodNameResolver;

import com.mwas.authentication.PageLoginCallBackHandler;
import com.mwas.datalayer.dao.ProfileDao;
import com.mwas.entities.Profile;
import com.mwas.spring.beans.authentication.AuthorizationService;

/**
 * @author kartik
 *
 */
@Controller
@SessionAttributes({"SPACESession","Employees"})
public class LoginController {

	private ParameterMethodNameResolver methodNameResolver;
	
	@Autowired
	private AuthorizationService authService;

	//@Autowired
	//private SPACESession userSession;
	
	@Autowired
	private ProfileDao profileDao;
	//private FMSession usersession=null;   //Later use a proper UserSession object ( subject,principal )
 	
	@RequestMapping(value="/home.htm" , method= RequestMethod.GET,params="submit=signIn")
	public ModelAndView signIn(HttpServletRequest arg0,
			HttpSession session) throws Exception 
	{
			// TODO Auto-generated method stub
			ModelAndView modelAndView = null;
			String user= arg0.getParameter("user");
			String password=arg0.getParameter("password");
			CallbackHandler cbh= new PageLoginCallBackHandler(user,password);
			
			if(authService.authorize(cbh) !=null)
			{
				modelAndView = new ModelAndView("datatable");
				SPACESession userSession = new SPACESessionImpl();
				modelAndView.addObject("SPACESession", userSession);
				modelAndView.addObject("Employees", profileDao.getAllProfiles());//adding employees to session can be heavy???
				//session.setAttribute("SPACESession", userSession);
				//session.setAttribute("Employees", profileDao.getAllProfiles());
				//modelAndView = homepageMV;
			}
			else
			{
				modelAndView = new ModelAndView("/login/login");
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
	public ModelAndView home(@ModelAttribute("Employees")List<Profile> employees,
							@ModelAttribute("SPACESession")SPACESession userSession) throws Exception
	{
		System.out.println("Enter home method");
		ModelAndView modelAndView = null;
		
		if (userSession !=null && userSession.isSessionLogin())
		{	
			modelAndView = new ModelAndView("datatable");
			userSession.setHomepagehit(userSession.getHomepagehit()+1);
			System.out.println("Homepagehits "+userSession.getHomepagehit());
			System.out.println("SecurityToken "+userSession.getSecurityToken());
			modelAndView.addObject("Employees", employees);
			//modelAndView=homepageMV;
			
		}
		else{
			//modelAndView=loginpageMV;
			modelAndView = new ModelAndView("/login/login");
		}
			
		
		System.out.println("Exit home method");
		return modelAndView;
	
	}
	
	@RequestMapping(value="/home.htm" , method= RequestMethod.POST,params="submit=signout")
	public ModelAndView logout(@ModelAttribute("SPACESession")SPACESession userSession
													,HttpServletRequest arg0) throws Exception
	{
		System.out.println("Logout method");
		if (userSession !=null && userSession.isSessionLogin())
		{
			System.out.println("SecurityToken "+userSession.getSecurityToken());
			userSession.destroy();
			userSession=null;
			//SPACESession.destroy(); ////  destroy this
			arg0.getSession().invalidate();
		}

		return new ModelAndView("/login/login");
		
			
	}
	
	/**
	 * @param methodNameResolver the methodNameResolver to set
	 */
	public void setMethodNameResolver(ParameterMethodNameResolver methodNameResolver) {
		this.methodNameResolver = methodNameResolver;
	}
		
}
