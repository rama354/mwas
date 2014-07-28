/**
 * 
 */
package com.mwas.spring.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mwas.authentication.SPACESession;

/**
 * @author kartik
 *
 */
@Controller
public class AJAXController 
{
	@Autowired
	private SPACESession userSession;
	
	@RequestMapping(value="/setSPACEID.htm",method = RequestMethod.POST)
	public @ResponseBody String setSPACEID(@RequestParam("spaceid")String spaceid,HttpServletRequest request)
	{
		System.out.println("spaceid"+spaceid.trim());
		//SPACESession spaceSession = (SPACESession)request.getSession().getAttribute("SPACESession");
		userSession.setSessionObject("spaceid", Integer.parseInt(spaceid.trim()));
		return "success";
	}
}
