package kr.ac.mnu.exsample.service.admin.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.mnu.exsample.model.board.BoardDAO;
import kr.ac.mnu.exsample.model.board.BoardDTO;
import kr.ac.mnu.exsample.service.Action;
import kr.ac.mnu.exsample.util.PageIndex;

public class AdminBoardViewService implements Action{
	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO boardDAO = BoardDAO.getInstance();
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/Admin/board_view.jsp");
		rd.forward(request, response);
	}

}
