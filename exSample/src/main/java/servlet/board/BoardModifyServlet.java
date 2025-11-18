package servlet.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.board.BoardDAO;
import model.board.BoardDTO;

/**
 * Servlet implementation class BoardModifyServlet
 */
@WebServlet("/Board/board_modify.do")
public class BoardModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		//db에서 idx에 해당하는 글 검색
		BoardDAO dao = BoardDAO.getInstance();
		
		BoardDTO dto = dao.boardSelect(idx);
		request.setAttribute("dto", dto);
		
		RequestDispatcher rd = request.getRequestDispatcher("/Board/board_modify.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		BoardDAO dao = BoardDAO.getInstance();
		BoardDTO dto = new BoardDTO();

		dto.setIdx(Integer.parseInt(request.getParameter("idx")));
		//dto.setName(request.getParameter("name"));
		dto.setEmail(request.getParameter("email"));
		dto.setSubject(request.getParameter("subject"));
		dto.setContents(request.getParameter("contents"));
		dto.setPass(request.getParameter("pass"));
		
		int row = dao.boardModify(dto);
		if(row==1) {
			response.sendRedirect("board_list.do");
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("/Board/board_modify_error.jsp");
			rd.forward(request, response);
		}
	}

}
