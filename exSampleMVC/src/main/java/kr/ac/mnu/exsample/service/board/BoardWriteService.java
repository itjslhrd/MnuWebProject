package kr.ac.mnu.exsample.service.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.mnu.exsample.service.Action;

public class BoardWriteService implements Action {
	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int page = 1;
		if(request.getParameter("page")!=null && 
				!request.getParameter("page").equals("")){
			page=Integer.parseInt(request.getParameter("page"));
		}
		
		request.setAttribute("page", page);
		
		RequestDispatcher rd = request.getRequestDispatcher("/Board/board_write.jsp");
		rd.forward(request, response);

	}

}
