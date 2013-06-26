package com.datatable;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.datatable.bean.Person;

/**
 * Servlet implementation class WorkBookServlet
 */
public class WorkBookServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private static final int BUFFER_SIZE = 8192;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WorkBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
 		ArrayList<Person> workBookRows = new ArrayList<Person>();
		//System.out.println("file location: "+request.getParameter("datafile"));
		Workbook wb=null;
		try 
		{ 
		   	File inp = new File(fileUpload(request, response));
		   	if (inp!= null)
		   	{ 
		   		if (inp.getName().endsWith(".jpg")||inp.getName().endsWith(".gif"))
		   		{
		   			System.out.println("Image path "+request.getContextPath()+'/'+inp.getName());
		   			request.setAttribute("image",request.getContextPath()+'/'+inp.getName());
		   			getServletContext().getRequestDispatcher("/pages/datatable.jsp").forward(request, response);	
		   		}
		   		else
		   		{
		   			wb = WorkbookFactory.create(inp);
		   			Sheet sheet = wb.getSheetAt(0);
		   			String employeeName= null;
		   			// TODO Auto-generated method stub
		   			boolean isAll = (request.getParameter("name")== null)?true:false;
		   			if (!isAll)
		   				employeeName=request.getParameter("name");
		   			
		   			//int rowcount=sheet.getLastRowNum()+1;
		   			
		   			Iterator<Row> rowIteration = sheet.rowIterator();
		   			
		   			while (rowIteration.hasNext())
		   			{
		   		     Row row = (Row)rowIteration.next();
		   			 if (row != null)
		   			 {
		   			    if (!isAll)
		   			    {
		   			    	String cellval= row.getCell(0).getStringCellValue();
		   			    	if (employeeName.equalsIgnoreCase(cellval))
		   			    	{
		   			    		workBookRows.add(createEntity(row));
		   			    		break;
		   			    	}	    	
		   			    }
		   			    else
		   			    {
		   			    	workBookRows.add(createEntity(row));
		   			    }
		   			 }
		   			}
		   			
		   			//rowcount=workBookRows.size();
		   			request.setAttribute("Employees", workBookRows);
		   			//response.getSession().setAttribute("Employees", workBookRows);
		   			//response.sendRedirect(response.encodeRedirectURL(request.getContextPath()+"/pages/datatable.jsp"));
		   			getServletContext().getRequestDispatcher("/pages/datatable.jsp").forward(request, response);	
		   			//return;
		   		}
		   	}
				
		} catch (ServletException e) 
		{
			redirectToErrorPage(request, e, response);
		}
		catch (IOException e){
			redirectToErrorPage(request, e, response);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			redirectToErrorPage(request, e, response);
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			redirectToErrorPage(request, e, response);
		}
		
	}

	@SuppressWarnings("unchecked") //Apache Commons FileUpload
	private String fileUpload(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException, FileUploadException
	{
		List<FileItem> items = null;
		items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
		String webAppPath=null; String filename=null;
		
		for (FileItem item : items) 
		{
            if (!item.isFormField()) 
            {
            	//String fieldname=item.getFieldName();
            	filename=FilenameUtils.getName(item.getName());
            	InputStream is = item.getInputStream();
            	BufferedInputStream bis = new BufferedInputStream(is);
            	
            	webAppPath=request.getSession().getServletContext().getRealPath(System.getProperty("file.separator"));
            	System.out.println("webAppPath "+webAppPath);
            	System.out.println("contextpath "+request.getContextPath());
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
		
		return webAppPath+filename;
	}
	
	private void redirectToErrorPage(HttpServletRequest request,Exception e,HttpServletResponse response) 
																    throws ServletException, IOException 															 
	{
		request.setAttribute("javax.servlet.jsp.JspException", e);
		getServletContext().getRequestDispatcher("/pages/error.jsp").forward(request, response);
		
	}
	
	private Person createEntity(Row row) 
	{
		ConcurrentHashMap<String, Object> attributeMap = new ConcurrentHashMap<String,Object>();
		Person person = new Person();
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

}
