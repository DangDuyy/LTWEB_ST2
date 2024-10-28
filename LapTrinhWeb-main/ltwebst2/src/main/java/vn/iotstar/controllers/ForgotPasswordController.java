package vn.iotstar.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.IUserService;
import vn.iotstar.services.implement.UserServiceImp;

@WebServlet(urlPatterns = { "/forgotpassword" })
public class ForgotPasswordController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	IUserService service = new UserServiceImp();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/forgotpassword.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String username = req.getParameter("uname");
		String email = req.getParameter("email");
		String password = req.getParameter("psw");
		String repassword = req.getParameter("psw-repeat");
		UserModel user = service.findByUserName(username);
		
		if (user == null || !user.getEmail().equals(email) || !user.getUsername().equals(username)) {
			req.setAttribute("alert", "Username or Email does not exist !");
			req.getRequestDispatcher("/views/forgotpassword.jsp").forward(req, resp);
		}
		else if (!password.equals(repassword)) {
			req.setAttribute("alert", "Passwords do not match!");
			req.getRequestDispatcher("/views/forgotpassword.jsp").forward(req, resp);
		}
		else {
			service.updatePassword(email, password);
	        req.setAttribute("alert", "Reset Password Successfully. Now you can return to Login");
	        req.getRequestDispatcher("/views/forgotpassword.jsp").forward(req, resp);
		}

	}
}
