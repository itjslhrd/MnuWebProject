package kr.ac.mnu.exsample.service.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.mnu.exsample.model.board.BoardDAO;
import kr.ac.mnu.exsample.model.board.BoardDTO;
import kr.ac.mnu.exsample.service.Action;

public class BoardWriteProService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int page = Integer.parseInt(request.getParameter("page"));
		
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setName(request.getParameter("name"));
		boardDTO.setEmail(request.getParameter("email"));
		boardDTO.setSubject(request.getParameter("subject"));
		boardDTO.setContents(request.getParameter("contents"));
		boardDTO.setPass(request.getParameter("pass"));
		
		BoardDAO boardDAO = BoardDAO.getInstance();
		int row = boardDAO.boardWrite(boardDTO);
		
		request.setAttribute("page", page);
		request.setAttribute("row", row);
		
		RequestDispatcher dispater = 
				request.getRequestDispatcher("Board/board_write_pro.jsp");
		dispater.forward(request, response);

	}

}
