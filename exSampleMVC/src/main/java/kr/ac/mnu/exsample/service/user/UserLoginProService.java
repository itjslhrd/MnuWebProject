package kr.ac.mnu.exsample.service.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.mnu.exsample.model.user.UserDAO;
import kr.ac.mnu.exsample.model.user.UserDTO;
import kr.ac.mnu.exsample.service.Action;
import kr.ac.mnu.exsample.util.UserSHA256;

public class UserLoginProService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userid = request.getParameter("userid");
		String passwd = UserSHA256.getSHA256(request.getParameter("passwd"));
		
		UserDAO userDAO = UserDAO.getInstance();
		
		int row = userDAO.userLogin(userid, passwd);
		
		if(row==1) {
			//로그인 성공(세션에 저장할 정보 검색);(name, id, tel)
			UserDTO userDTO = userDAO.userSelect(userid);
			//세션 형성
			HttpSession session = request.getSession();
			session.setAttribute("user", userDTO);
			session.setMaxInactiveInterval(1800);//세션유지시간30분
		}
		
		request.setAttribute("row", row);

		RequestDispatcher rd = request.getRequestDispatcher("/User/user_login_pro.jsp");
		rd.forward(request, response);
	}

}
