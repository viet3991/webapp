package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ListProductDAO;
import model.Cart;
import model.Product;

/**
 * Servlet implementation class AddToCartController
 */
@WebServlet(urlPatterns = {"/AddToCartController", "/addToCart"})
public class AddToCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setContentType("text/html; charset=UTF-8");
			HttpSession ss = request.getSession();
			String idString = request.getParameter("id");
			int id = Integer.parseInt(idString);
			String action = request.getParameter("action");	
			Product p = new ListProductDAO().getProduct(idString);
			Cart c = (Cart) ss.getAttribute("cart");
			
			if (action != null && action.equalsIgnoreCase("add")) {
				c.add(p);
			} else if (action != null && action.equalsIgnoreCase("sub")) {
				c.sub(p);
			} else if (action != null && action.equalsIgnoreCase("remove")) {
				c.remove(id);
			}
			
			double total = c.getAmount();
			ss.setAttribute("total", total);
			ss.setAttribute("cart", c);
			response.sendRedirect("cart.jsp");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			response.setContentType("text/html; charset=UTF-8");
			HttpSession ss = request.getSession();
			String idString = request.getParameter("id");
			String action = request.getParameter("action");	
			Product p = null;
			try {
				p = new ListProductDAO().getProduct(idString);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Cart c = (Cart) ss.getAttribute("cart");
			
			String account = request.getParameter("name");
			if (account == "") {
				response.sendRedirect("login.jsp");
			} else {
			
				if (action != null && action.equalsIgnoreCase("addCart")) {
					if (c == null) {
						c = new Cart();
					} 
				
					c.add(new Product(p.getId(), 
							p.getName(), 
							p.getDescription(), 
							p.getPrice(), 
							p.getSrc(), 
							p.getType(), 
							p.getBrand(), 
							1));
					
					double total = c.getAmount();
					ss.setAttribute("total", total);
					ss.setAttribute("cart", c);
					response.sendRedirect("cart.jsp");
			
				}
			}

	}
}
