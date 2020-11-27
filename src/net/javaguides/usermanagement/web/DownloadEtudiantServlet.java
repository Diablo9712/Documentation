package net.javaguides.usermanagement.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 * Servlet implementation class DownloadEtudiantServlet
 */

@WebServlet( name = "DownloadEtudiantServlet", urlPatterns = {"/DownloadEtudiantServlet"})

public class DownloadEtudiantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static int BUFFER_SIZE = 1024 * 100;
	public static final String UPLOAD_DIR = "resources";
	public static String fileName = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadEtudiantServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		fileName = request.getParameter("fileName");
		if(fileName == null || fileName.equals("")) {
			response.setContentType("text/html");
			response.getWriter().println("<h3>File "+fileName+" is not Present ....!</h3>");
			
		}else {
			
			String applicationPath = getServletContext().getRealPath("");
			String downloadPAth = applicationPath + File.separator+UPLOAD_DIR;
			
			String filePath = downloadPAth + File.separator + fileName;
			System.out.println(fileName);
			System.out.println(filePath);
			System.out.println("fileName : "+fileName);
			System.out.println("filePath : "+fileName);
			File file = new File(filePath);
			OutputStream outStream = null;
			FileInputStream input = null;
			
			if(file.exists()) {
				String mimeType = "application/octet-stream";
				response.setContentType(mimeType);
				
				String headerKey = "Content-Disposition";
				String headerValue = String.format("attachement; filename = \"%s\"", file.getName());
				response.setHeader(headerKey, headerValue);
				
				try {
					outStream = response.getOutputStream();
					input = new FileInputStream(file);
					byte[] buffer =  new byte[BUFFER_SIZE];
					int bytesRead = -1;
					while((bytesRead = input.read(buffer)) !=-1) {
						outStream.write(buffer,0,bytesRead);
					}
				}catch(IOException ioExObj) {
					System.out.println("Exception While Performing The I/O  Operation?= "+ioExObj.getMessage());
				}finally {
					
					if(input != null) {
						input.close();
					}
					
					outStream.flush();
					if(outStream !=null) {
						outStream.close();
					}
				}
			}
		}
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
