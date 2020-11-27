package net.javaguides.usermanagement.web;

import  net.javaguides.usermanagement.web.DB;
import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
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
 * Servlet implementation class UploadServlet
 */
@WebServlet( name ="UploadServlet", urlPatterns = {"/UploadServlet"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 *10 , 
	maxFileSize = 1024 * 1024 * 1000,
	maxRequestSize = 1024 * 1024 * 1000
		)
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       PrintWriter out = null;
       Connection cn = null;
       PreparedStatement ps = null;
       HttpSession session = null;
        long xx;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	doGet(request, response);
		response.setContentType("text/plain;charset=UTF-8");
		try {
			out = response.getWriter();
			String folderName = "resources";
			String uploadPath = request.getServletContext().getRealPath("")+File.separator+folderName;
					
					File dir = new File(uploadPath);
			if(!dir.exists()) {
				dir.mkdirs();
			}
			Part filePart =  request.getPart("file");
			String document =request.getParameter("document");
			String user = request.getParameter("user");
			String fileName = filePart.getSubmittedFileName();
			String path = folderName + File.separator+fileName;
			Timestamp added_date = new Timestamp(System.currentTimeMillis());
		//	System.out.println("fileName" + fileName);
		//	System.out.println("Path" + uploadPath);
		//	System.out.println("Name : " + firstName+" "+lastName);
			InputStream is = filePart.getInputStream();
			Files.copy(is,  Paths.get(uploadPath + File.separator + fileName), StandardCopyOption.REPLACE_EXISTING);
			try {
				cn=DB.getConnection();
				System.out.println("Connection Done");
				String sql = "INSERT INTO `document_demander`(`id`, `document_id`, `user_id`, `fileName`, `path`) VALUES (NULL,?,?,?,?)";
				ps = cn.prepareStatement(sql);
				ps.setString(1, document);
				ps.setString(2, user);
				ps.setString(3, fileName);
				ps.setString(4, path);
				 HttpSession session=request.getSession();  
			          
				
				int status = ps.executeUpdate();
				if(status > 0) {
					//session.setAttribute("fileName", fileName);
					session.setAttribute("fileName ", fileName);
					String msg = " "+fileName + " File uploaded successfully ....";
					request.setAttribute("msg", msg);
					RequestDispatcher rd = request.getRequestDispatcher("/DocumentDemander");
					rd.forward(request, response);
					System.out.println("File Uploaded Successfully ......"+ msg);
					System.out.println("File Uploaded  ...... " +uploadPath);
					
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
