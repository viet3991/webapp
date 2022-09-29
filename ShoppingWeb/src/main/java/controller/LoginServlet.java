package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import account.Account;
import dao.ListProductDAO;
import dao.LoginDAO;
import model.Cart;
import model.Product;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if ("login".equals(action)) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else if ("register".equals(action)) {
			response.sendRedirect("register.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		try {
				request.getSession().invalidate();
				
				// collect user and pass from login form
				String user = request.getParameter("usermail");
				String pass = request.getParameter("password");
				String remem = request.getParameter("remember");
				
				// make sure that email and pass are valid
				String regexMail = "^[A-Za-z0-9_]+@[A-Za-z0-9\\.]+\\.[A-Za-z]{2,6}$";
				String regexPass = "[a-zA-Z0-9_!@#$%^&*]+";
				
				HttpSession session = request.getSession();
				
				// check user and pass
				if (user.matches(regexMail) && pass.matches(regexPass)) {
					// check account in database
					LoginDAO dao = new LoginDAO();
					Account a = dao.login(user, pass);
					if (a != null) {
						// set session
						// session.setAttribute("userLogin", user);
						
						// cookie	
						if (remem != null) {
						Cookie ckUser = new Cookie("cookieUser", user);
						Cookie ckPass = new Cookie("cookiePass", pass);
						Cookie ckCheck = new Cookie("cookieCheck", remem);
						
						ckUser.setMaxAge(60 * 60 * 24 * 7);
						ckPass.setMaxAge(60 * 60 * 24 * 7);
						ckCheck.setMaxAge(60 * 60 * 24 * 7);
						
						response.addCookie(ckUser);
						response.addCookie(ckPass);
						response.addCookie(ckCheck);
						}
						
						// 
						session.setAttribute("acc", a);
						
						Cart c = new LoginDAO().getOrderDetail(a.getUsr());
						double total = c.getAmount();
						session.setAttribute("total", total);
						session.setAttribute("cart", c);
						
						
						// redirect buyer
						if (a.getRole() == 0) {							
							response.sendRedirect("cart.jsp");
						} 
						// redirect admin
						else if (a.getRole() == 1) {						
							List<Product> listAll = new ListProductDAO().getAll();
							request.setAttribute("list", listAll);
							
							request.getRequestDispatcher("/admin.jsp").forward(request, response);
						}
						
					} else {
						session.setAttribute("error", "wrong username or password");
						request.getRequestDispatcher("/login.jsp").forward(request, response);
					}
				} else {
					session.setAttribute("error", "invalid syntax");
					request.getRequestDispatcher("/login.jsp").forward(request, response);
				}

				
		} catch(NullPointerException ex) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} catch (Exception e) {
			response.getWriter().println(e);
		} 
	}
	
	
}
