package com.proj.serv;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Date;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.proj.db.DBConnection;
import com.proj.vo.DataVO;

@WebServlet("/CollectData")
@MultipartConfig
public class CollectData extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static String PATH = null; 
	@Override
	public void init() {
		if(PATH == null) {
			try (InputStream input = getClass().getClassLoader().getResourceAsStream("com/proj/resources/proj.properties")) {
				Properties prop = new Properties();
				prop.load(input);	
				PATH = prop.getProperty("uploadPath");
				System.out.println("Loaded path is: "+PATH);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			DataVO data = new DataVO();
			data.setExternal_id(request.getParameter("id"));
			data.setAge(Float.parseFloat(request.getParameter("age")));
			data.setHb(Float.parseFloat(request.getParameter("hb")));
			data.setPregnant(request.getParameter("preg")==null?0:1);
			data.setBlood_group(request.getParameter("bGroup"));		
			data.setGender(Integer.parseInt(request.getParameter("gender")));
			data.setComments(request.getParameter("misc"));

			long myId = new Date().getTime(); Part filePart1 = request.getPart("vFile1");
			String fileName1 = PATH+myId+"_samsung_"+getFilename(filePart1);
			filePart1.write(fileName1);
			data.setSamsung_file_link(fileName1);
			
			Part filePart2 = request.getPart("vFile2"); 
			String fileName2 = PATH+myId+"_remi_"+getFilename(filePart2); 
			filePart2.write(fileName2);
			data.setRedmi_file_link(fileName2);

			System.out.println(data.toString());
			
			DBConnection dbCon = new DBConnection();
			dbCon.insertData(data);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.getWriter().append("Accepting Data requests!");
	}

	private static String getFilename(Part part) {
		for (String cd : part.getHeader("content-disposition").split(";")) {
			if (cd.trim().startsWith("filename")) {
				String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
				return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE fix.
			}
		}
		return null;
	}

}//EOC