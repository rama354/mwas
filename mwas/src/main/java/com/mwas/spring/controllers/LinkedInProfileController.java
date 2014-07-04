/**
 * 
 */
package com.mwas.spring.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mwas.entities.LinkedInProfile;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.mwas.authentication.FMSession;
import com.mwas.datalayer.dao.FMDao;
import com.mwas.entities.Education;
import com.mwas.entities.Profile;
import com.mwas.entities.Work;

/**
 * @author asus
 *
 */
@Controller
@SessionAttributes({"futureMaker"})
public class LinkedInProfileController
{

private final ModelAndView profileMV=new ModelAndView("/profile/profile");
private LinkedInProfile linkedInProfile;


 @ModelAttribute("linkedInProfile")
 public LinkedInProfile getProfileFromDB(@ModelAttribute("FMSession") FMSession fmsession)
 {
	FMDao fmDao = new FMDao();
	//System.out.println("getProfileFromDB");
	return linkedInProfile = fmDao.getLinkedInProfile(fmsession.getFmid());
  }
 
 @ModelAttribute("aboutMe")
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
 
@RequestMapping(value="/profile.htm",method=RequestMethod.GET,params="submit=profile")
public ModelAndView createProfile(HttpServletRequest arg0,HttpServletResponse arg1)
{
	return profileMV;	
}

@RequestMapping(value="/aboutme.htm", method=RequestMethod.POST,params="submit=save")
public String setAboutMe(@RequestParam("aboutme")String summary,HttpSession session)
{
	linkedInProfile.setSummary(summary);
    FMSession fmsession = (FMSession)session.getAttribute("FMSession");
    
	FMDao fmDao = new FMDao();
	fmDao.setLinkedInProfile(linkedInProfile);
	
	return "redirect:/profile.htm";
}
}