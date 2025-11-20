package servlet.boardphoto;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.boardphoto.BoardPhotoDAO;
import model.boardphoto.BoardPhotoDTO;

/**
 * Servlet implementation class BoardPhotoViewServlet
 */
@WebServlet("/BoardPhoto/board_view.do")
public class BoardPhotoViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardPhotoViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		BoardPhotoDAO dao = BoardPhotoDAO.getInstance();
		
		BoardPhotoDTO dto = dao.boardSelect(idx);
		
		request.setAttribute("dto", dto);
		
		RequestDispatcher rd = request.getRequestDispatcher("/BoardPhoto/board_view.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
