package kr.ac.mnu.exsample.service.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.mnu.exsample.model.user.UserDAO;
import kr.ac.mnu.exsample.service.Action;

public class UserIdCheckService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		
		System.out.println("userid :" + userid);
		//DB 연결
		UserDAO userDAO = UserDAO.getInstance();
		
		int row = userDAO.userIdCheck(userid);
		System.out.println("row:" + row);
		
		response.getWriter().append(String.valueOf(row));

	}

}
