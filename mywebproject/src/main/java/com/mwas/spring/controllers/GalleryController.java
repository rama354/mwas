/**
 * 
 */
package com.mwas.spring.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author asus
 *
 */
@Controller
public class GalleryController 
{
	ModelAndView galleryMV;
	{
		try{
			galleryMV = new ModelAndView("/gallery/gallery");
		}
		catch(Exception e){
			
		}
		
	}
	
	
	@RequestMapping(value="/gallery.htm",method=RequestMethod.GET,params="submit=gallery")
	public ModelAndView uploadToGallery(HttpServletRequest arg0,
										HttpServletResponse arg1) throws Exception
	{
		//Object profileImages;
		//Download Images from database - mysql
		//and show on page
		//galleryMV.addObject("Images", profileImages);
		return galleryMV;
		
	}

}
