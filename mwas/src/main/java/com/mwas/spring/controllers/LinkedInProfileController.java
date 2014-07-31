/**
 * 
 */
package com.mwas.spring.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mwas.entities.LinkedInProfile;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.mwas.authentication.SPACESession;
import com.mwas.datalayer.dao.ProfileDao;
import com.mwas.entities.Education;
import com.mwas.entities.Profile;
import com.mwas.entities.Work;

/**
 * @author asus
 *
 */
@Controller
public class LinkedInProfileController
{

//private final ModelAndView profileMV=new ModelAndView("/profile/profile");
//private LinkedInProfile linkedInProfile;
@Autowired
private ProfileDao profileDao;
@Autowired
private SPACESession userSession;

 @ModelAttribute("linkedInProfile")
 public Profile getProfileFromDB(HttpServletRequest request)
 {
	//SPACESession spaceSession=(SPACESession)request.getSession().getAttribute("SPACESession");
	return profileDao.getProfile((Integer)userSession.getSessionObject("spaceid"));
  }
 
 /*@ModelAttribute("aboutMe")
 public String getSummary()
 {
	 return linkedInProfile.getSummary();
 }
 
 @ModelAttribute("ehrray")
 public List getEducation()
 {
	return linkedInProfile.getEducationHistory();
	 
 }
 
 @ModelAttribute("wharray")
 public Work[] getWorkHistory()
 {
	 return getWorkHistory();
 }
 */
@RequestMapping(value="/profile.htm",method=RequestMethod.GET,params="submit=profile")
public ModelAndView createProfile(HttpServletRequest arg0,HttpServletResponse arg1)
{
	return new ModelAndView("/profile/profile");
}

@RequestMapping(value="/aboutme.htm", method=RequestMethod.POST,params="submit=save")
public String setAboutMe(@RequestParam("aboutme")String summary)
{
	//linkedInProfile.setSummary(summary);
	//SPACESession spaceSession = (SPACESession)session.getAttribute("SPACESession");   
    //profileDao.setLinkedInProfile(linkedInProfile);
	
	return "redirect:/profile.htm";
}

}