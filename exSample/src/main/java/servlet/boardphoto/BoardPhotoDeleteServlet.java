package servlet.boardphoto;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.boardphoto.BoardPhotoDAO;

/**
 * Servlet implementation class BoardPhotoDeleteServlet
 */
@WebServlet("/BoardPhoto/board_delete.do")
public class BoardPhotoDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardPhotoDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		request.setAttribute("idx", idx);
		
		RequestDispatcher rd = request.getRequestDispatcher("/BoardPhoto/board_delete.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		String pass = request.getParameter("pass");
		
		BoardPhotoDAO dao = BoardPhotoDAO.getInstance();
		
		int row = dao.boardPhotoDelete(idx,pass);
		
		request.setAttribute("row", row);

		RequestDispatcher rd = request.getRequestDispatcher("/BoardPhoto/board_delete_pro.jsp");
		rd.forward(request, response);
		
	}

}
