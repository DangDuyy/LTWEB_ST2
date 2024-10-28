package vn.iotstar.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.services.IUserService;
import vn.iotstar.services.implement.UserServiceImp;
import vn.iotstar.utils.Constant;

@WebServlet(urlPatterns = { "/Path.REGISTER" })
public class RegisterController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	IUserService service = new UserServiceImp();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		HttpSession session = req.getSession(false);
//		if (session != null && session.getAttribute("username") != null) {
//			resp.sendRedirect(req.getContextPath() + "/admin");
//			return;
//		}
//		// Check cookie
//		Cookie[] cookies = req.getCookies();
//		if (cookies != null) {
//			for (Cookie cookie : cookies) {
//				if (cookie.getName().equals("username")) {
//					session = req.getSession(true);
//					session.setAttribute("username", cookie.getValue());
//					resp.sendRedirect(req.getContextPath() + "/admin");
//					return;
//				}
//			}
//		}
		req.getRequestDispatcher(Constant.Path.REGISTER).forward(req, resp);
	}

	//@SuppressWarnings("static-access")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String username = req.getParameter("uname");
		String password = req.getParameter("psw");
		String repassword = req.getParameter("psw-repeat");
		String email = req.getParameter("email");
		String fullname = req.getParameter("fullName");
		String phone = req.getParameter("phone");
		
		String alertMsg = "";

		if (service.checkExistEmail(email)) {
			alertMsg = "Email đã tồn tại!";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher(Constant.Path.REGISTER).forward(req, resp);
			return;
		}
		if (service.checkExistUsername(username)) {
			alertMsg = "Tên người dùng đã tồn tại!";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher(Constant.Path.REGISTER).forward(req, resp);
			return;
		}
		if (service.checkExistPhone(phone)) {
			alertMsg = "Số điện thoại đã tồn tại!";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher(Constant.Path.REGISTER).forward(req, resp);
			return;
		}
		if (!password.equals(repassword)) {
		    alertMsg = "Mật khẩu và mật khẩu xác nhận không khớp!";
		    req.setAttribute("alert", alertMsg);
		    req.getRequestDispatcher(Constant.Path.REGISTER).forward(req, resp);
		    return;
		}
		
		boolean isSuccess = service.register(email, password, username, fullname, phone);
		if (isSuccess) {
		//SendMail sm = new SendMail();
		//sm.sendMail(email, "Shopping.iotstar.vn", "Welcome to Shopping. Please Login to use service. Thanks !");
			req.setAttribute("alert", alertMsg);
			resp.sendRedirect(req.getContextPath() + "/login");
		} else {
			alertMsg = "System error!";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher(Constant.Path.REGISTER).forward(req, resp);
		}
	}

}
