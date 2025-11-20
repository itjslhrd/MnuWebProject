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
 * Servlet implementation class BoardPhotoModifyServlet
 */
@WebServlet("/BoardPhoto/board_modify.do")
public class BoardPhotoModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardPhotoModifyServlet() {
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
		
		RequestDispatcher rd = request.getRequestDispatcher("/BoardPhoto/board_modify.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		BoardPhotoDTO dto = new BoardPhotoDTO();
		dto.setIdx(Integer.parseInt(request.getParameter("idx")));
		dto.setSubject(request.getParameter("subject"));
		dto.setContents(request.getParameter("contents"));
		dto.setPass(request.getParameter("pass"));
		
		BoardPhotoDAO dao = BoardPhotoDAO.getInstance();
		
		int row = dao.boardPhotoModify(dto);
/*		
		if(row==1) {
			//수정 성공시
			response.sendRedirect("board_list.do");
		}else {
			//수정 실패시
			RequestDispatcher rd = request.getRequestDispatcher("/BoardPhoto/board_modify_error.jsp");
			rd.forward(request, response);
		}
*/
		request.setAttribute("row", row);
		//성공 또는 실패시 경고창
		RequestDispatcher rd = request.getRequestDispatcher("/BoardPhoto/board_modify_error.jsp");
		rd.forward(request, response);
		
	}

}
