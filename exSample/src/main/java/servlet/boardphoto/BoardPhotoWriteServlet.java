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
 * Servlet implementation class BoardPhotoWriteServlet
 */
@WebServlet("/BoardPhoto/board_write.do")
public class BoardPhotoWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardPhotoWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("/BoardPhoto/board_write.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		BoardPhotoDAO dao = BoardPhotoDAO.getInstance();
		BoardPhotoDTO dto = new BoardPhotoDTO();
				
		String name = request.getParameter("name");
		String subject = request.getParameter("subject");
		String contents = request.getParameter("contents");
		String pass = request.getParameter("pass");
		
		dto.setName(name);
		dto.setSubject(subject);
		dto.setContents(contents);
		dto.setPass(pass);
		
		int row = dao.boardPhotoWrite(dto);
		
		if(row==1) {
			response.sendRedirect("board_list.do");
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("/BoardPhoto/board_write.jsp");
			rd.forward(request, response);
		}
		
	
	}

}
