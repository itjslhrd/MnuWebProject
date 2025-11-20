package servlet.boardphoto;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.boardphoto.BoardPhotoDAO;
import model.boardphoto.BoardPhotoDTO;

/**
 * Servlet implementation class BoardPhotoListServlet
 */
@WebServlet("/BoardPhoto/board_list.do")
public class BoardPhotoListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardPhotoListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		BoardPhotoDAO dao = BoardPhotoDAO.getInstance();
		
		String search="", key="";
		List<BoardPhotoDTO> list = null;
		int counter = 0;

		if(request.getParameter("key") != null) {
			search=request.getParameter("search");
			key=request.getParameter("key");
			list = dao.boardList(search, key);
			counter = dao.boardCount(search, key);
			
		}else {
			list = dao.boardList();
			counter = dao.boardCount();
		}
		
		request.setAttribute("list", list);
		request.setAttribute("counter", counter);
		request.setAttribute("search", search);
		request.setAttribute("key", key);
		
		RequestDispatcher rd = request.getRequestDispatcher("/BoardPhoto/board_list.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request,response);
		
/*		
		request.setCharacterEncoding("utf-8");
		
		String search = request.getParameter("search");
		String key = request.getParameter("key");
		
		BoardPhotoDAO dao = BoardPhotoDAO.getInstance();
		
		List<BoardPhotoDTO> list = dao.boardList(search, key);
		int counter = dao.boardCount(search, key);
		
		request.setAttribute("list", list);
		request.setAttribute("counter", counter);

		RequestDispatcher rd = request.getRequestDispatcher("/BoardPhoto/board_list.jsp");
		rd.forward(request, response);
*/		
	}

}
