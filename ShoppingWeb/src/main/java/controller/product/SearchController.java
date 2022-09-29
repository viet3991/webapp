package controller.product;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ListProductDAO;
import model.Product;

/**
 * Servlet implementation class SearchController
 */
@WebServlet("/SearchController")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		String name = request.getParameter("txtSearch");
		String indexS = request.getParameter("indexS");
		String role = request.getParameter("role");
		
		int index = Integer.parseInt(indexS);
		try {
			List<Product> listS = new ListProductDAO().getSearch(name, index);
			List<Product> listSAdmin = new ListProductDAO().getSearch(name);
			if (listS.isEmpty()) {
				request.setAttribute("txtS", name);
				request.getRequestDispatcher("/notFound.jsp").forward(request, response);
			}

			int count = new ListProductDAO().countSearch(name);
			int endPage = count / 6;
			if (count % 6 != 0) {
				endPage++;
			}
			request.setAttribute("endPage", endPage);
			request.setAttribute("txtS", name);
			request.setAttribute("tag", index);
			
			
			if (role == "" || role == null || role.equals("0")) {
				request.setAttribute("list", listS);
				request.getRequestDispatcher("/search.jsp").forward(request, response);
			} else if (role.equals("1")) {
				request.setAttribute("list", listSAdmin);
				request.getRequestDispatcher("/admin.jsp").forward(request, response);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
