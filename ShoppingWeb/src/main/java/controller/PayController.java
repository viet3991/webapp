package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.OrdersDAO;
import model.Cart;
import model.Orders;

/**
 * Servlet implementation class PayController
 */
@WebServlet(urlPatterns = {"/PayController", "/pay"})
public class PayController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setContentType("text/html; charset=UTF-8");
			request.setCharacterEncoding("utf-8");
			
			HttpSession session = request.getSession();
			
			
			OrdersDAO dao = new OrdersDAO();
			Cart c = (Cart) session.getAttribute("cart");
			String userMail = request.getParameter("usermail");
			String address = request.getParameter("adr");
			String discount = request.getParameter("discount");
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
	        String strDate = formatter.format(date);
			Orders od = new Orders(userMail, 2, strDate, discount, address);
			dao.insertOrder(od, c);
			response.sendRedirect("home");	
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
