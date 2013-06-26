/**
 * 
 */
package com.mwas.spring.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.datatable.bean.Person;

/**
 * @author asus
 *
 */
@Controller
@SessionAttributes("Employees")
public class FileUploadController{

	//private final int BUFFER_SIZE = 8192;
	/**
	 * @return 
	 * 
	 */
	//@SuppressWarnings("unchecked")
	/*@RequestMapping(value = "/datagrid.htm", method = RequestMethod.POST)
	public String fileUpload(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception
	{
				
		List<FileItem> items = null;
		items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(arg0);
		String webAppPath=null; String filename=null;
		
		for (FileItem item : items) 
		{
		if (!item.isFormField()) 
		{
		//String fieldname=item.getFieldName();
		filename=FilenameUtils.getName(item.getName());
		InputStream is = item.getInputStream();
		BufferedInputStream bis = new BufferedInputStream(is);
		
		webAppPath=arg0.getSession().getServletContext().getRealPath(System.getProperty("file.separator"));
		System.out.println("webAppPath "+webAppPath);
		System.out.println("contextpath "+arg0.getContextPath());
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(webAppPath+filename));
		
		byte[] buffer = new byte[BUFFER_SIZE]; 
		while(bis.read(buffer)!=-1)
		{
		bos.write(buffer);
		
		}
		bos.flush();
		bos.close();
		}
	  }
		
		ArrayList<Person> datagrid = createDataGrid(new File(webAppPath+filename), arg0);
		
		arg0.setAttribute("Employees", datagrid);
		
		return "redirect:/home.htm";
	}	
	*/
	
	private ArrayList<Person> workBookRows = null;
	
	@RequestMapping(value = "/datagrid.htm", method = RequestMethod.POST)
	public ModelAndView fileUpload(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception
	{
		// Check that we have a file upload request		
		boolean isMultipart = ServletFileUpload.isMultipartContent(arg0);
		ArrayList<Person> datagrid=null;
		String employeeName=null;
		
		if (isMultipart)
		{
			ServletFileUpload upload = new ServletFileUpload();
			FileItemIterator iter = upload.getItemIterator(arg0);
			while (iter.hasNext()) 
			{
			    FileItemStream item = iter.next();
			    InputStream stream = item.openStream();
			    
			    if (item.isFormField() && item.getFieldName().equalsIgnoreCase("name"))
			    {
			    	employeeName = Streams.asString(stream);
			    	System.out.println("employeename: "+employeeName);
			    }
			    else
			    {
			    	String name = item.getFieldName();
			    	System.out.println("File field " + name + " with file name "
			                + item.getName() + " detected.");
			    	   //stream upload
			    	datagrid = createDataGrid(stream, arg0,employeeName);
			    	
			    }
			}
		}
		//items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(arg0);
		//String webAppPath=null; String filename=null;
		//arg0.setAttribute("Employees", datagrid);
		ModelAndView modelAndView = new ModelAndView("datatable");
		modelAndView.addObject("Employees", datagrid);
		//return "redirect:/pages/datatable.jsp";
		return modelAndView;
		
	  }
			
	private ArrayList<Person> createDataGrid(InputStream inp,HttpServletRequest arg0,String empname) 
	{
		workBookRows = new ArrayList<Person>();
		Workbook wb=null;
		try {
			wb = WorkbookFactory.create(inp);
			//wb = new XSSFWorkbook(inp.getAbsolutePath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			Sheet sheet = wb.getSheetAt(0);
			//System.out.println("name :"+arg0.getParameter("name"));
			boolean isAll = (empname.length()==0)?true:false;
			//if (!isAll)
			Iterator<Row> rowIteration = sheet.rowIterator();
			boolean isEmpRowIdentified=false;    // If an employee name is sent in the Form
			
			while (rowIteration.hasNext() && !isEmpRowIdentified)
			{
			     Row row = (Row)rowIteration.next();
				 if (row != null)
				 {
				    if (!isAll)
				    {
				    	Iterator<Cell> cellIteration = row.cellIterator();
				    	while (cellIteration.hasNext())
				    	{
				    		Cell cell= (Cell)cellIteration.next();
				    		if (cell != null)
				    		{
				    			isEmpRowIdentified=identifyRow(cell,empname);
				    		    break;
				    		}
				    	}
				    	if (isEmpRowIdentified)
				    		workBookRows.add(createEntity(row));
				    }
				    else
				    {
				    	workBookRows.add(createEntity(row));
				    }
				 }
			}
			return workBookRows;
			
			//rowcount=workBookRows.size();	
	}

	private boolean identifyRow(Cell cell, String empname) 
	{
		// TODO Auto-generated method stub
	    String cellval=cell.getStringCellValue();
		if (cellval.contains(empname))
				return true;
		
		return false;
	}

	private Person createEntity(Row row) 
	{
		ConcurrentHashMap<String, Object> attributeMap = new ConcurrentHashMap<String,Object>();
		Person person = new Person();
		@SuppressWarnings("unchecked")
		ArrayList<String> attribList = (ArrayList<String>) person.getAttributes();
		int len =attribList.size();int i=0;
		
		Iterator<Cell> cellIteration = row.cellIterator();
		
		while (cellIteration.hasNext())
		{
			Cell cell= (Cell)cellIteration.next();
			if (cell != null  && i < len)
			{
				if (cell.getCellType()== Cell.CELL_TYPE_NUMERIC)
					attributeMap.put(attribList.get(i++), (int)cell.getNumericCellValue());
				else if (cell.getCellType()==Cell.CELL_TYPE_STRING)
					attributeMap.put(attribList.get(i++), cell.getStringCellValue());
			}
		}
		
		person.setAttributeValues(attributeMap);
		return person;
	}

	@RequestMapping(value = "/image.htm", method = RequestMethod.POST)
	public void imageUpload(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception{
		
	}
	
}
