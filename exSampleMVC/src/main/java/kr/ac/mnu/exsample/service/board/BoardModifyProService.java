package kr.ac.mnu.exsample.service.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.mnu.exsample.model.board.BoardDAO;
import kr.ac.mnu.exsample.model.board.BoardDTO;
import kr.ac.mnu.exsample.service.Action;

public class BoardModifyProService implements Action {
	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int page = Integer.parseInt(request.getParameter("page"));
		
		BoardDTO boardDTO = new BoardDTO();
		
		boardDTO.setIdx(Integer.parseInt(request.getParameter("idx")));
		boardDTO.setName(request.getParameter("name"));
		boardDTO.setEmail(request.getParameter("email"));
		boardDTO.setSubject(request.getParameter("subject"));
		boardDTO.setContents(request.getParameter("contents"));
		boardDTO.setPass(request.getParameter("pass"));
		
		BoardDAO boardDAO = BoardDAO.getInstance();
		
		int row = boardDAO.boardModify(boardDTO);
		
		request.setAttribute("row", row);
		request.setAttribute("page", page);
		
		//경고페이지 사용시
		RequestDispatcher dispater = 
				request.getRequestDispatcher("/Board/board_modify_pro.jsp");
		dispater.forward(request, response);
		
		//경고페이지 미사용시
		//response.sendRedirect("board_list.do?page="+page);
	
	}
}
