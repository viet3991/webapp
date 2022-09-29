package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import account.Account;
import dao.ListProductDAO;
import dao.LoginDAO;
import model.Product;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet(urlPatterns = {"/RegisterServlet", "/register"})
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
	@SuppressWarnings("null")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		String user = request.getParameter("usermail");
		String pass = request.getParameter("password");
		String repass = request.getParameter("repass");
		
		String regexMail = "^[A-Za-z0-9_]+@[A-Za-z0-9\\.]+\\.[A-Za-z]{2,6}$";
		String regexPass = "[a-zA-Z0-9_!@#$%^&*]+";
		
		if (user.matches(regexMail) && pass.matches(regexPass)) {
			if (pass.equals(repass)) {
				try {
					LoginDAO dao = new LoginDAO();
					Account a = dao.checkAcc(user);
					if (a == null) {
						String role = request.getParameter("role");
						int rol = Integer.parseInt(role);
						String name = request.getParameter("name");
						String address = request.getParameter("address");
						String phone = request.getParameter("phone");
						
						dao.create(user, pass, rol, name, address, phone);
						
						session.setAttribute("acc", a);
						
						request.getRequestDispatcher("home").forward(request, response);
						
					} else {
						request.setAttribute("error", "email exists");
						request.getRequestDispatcher("/register.jsp").forward(request, response);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} else {
				request.setAttribute("error", "password do not match");
				request.getRequestDispatcher("/register.jsp").forward(request, response);
			}
			
		} else {
			request.setAttribute("error", "invalid syntax");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		}
		
	}

}
