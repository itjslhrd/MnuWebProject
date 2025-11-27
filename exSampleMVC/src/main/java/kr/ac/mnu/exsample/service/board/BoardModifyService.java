package kr.ac.mnu.exsample.service.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.mnu.exsample.model.board.BoardDAO;
import kr.ac.mnu.exsample.model.board.BoardDTO;
import kr.ac.mnu.exsample.service.Action;

public class BoardModifyService implements Action {
	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		int page = Integer.parseInt(request.getParameter("page"));
		BoardDAO boardDAO = BoardDAO.getInstance();
		BoardDTO boardDTO = boardDAO.boardSelect(idx);
		
		request.setAttribute("page", page);
		request.setAttribute("boardDTO", boardDTO);
		
		RequestDispatcher dispater = 
				request.getRequestDispatcher("/Board/board_modify.jsp");
		dispater.forward(request, response);
	}

}
