package kr.ac.mnu.exsample.service.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.mnu.exsample.model.user.UserDAO;
import kr.ac.mnu.exsample.model.user.UserDTO;
import kr.ac.mnu.exsample.service.Action;
import kr.ac.mnu.exsample.util.UserSHA256;

public class UserModifyProService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDTO userDTO = new UserDTO();
		userDTO.setName(request.getParameter("name"));
		userDTO.setUserid(request.getParameter("userid"));
		userDTO.setPasswd(UserSHA256.getSHA256(request.getParameter("passwd")));
		userDTO.setTel(request.getParameter("tel"));
		
		UserDAO userDAO = UserDAO.getInstance();
		
		int row = userDAO.userModify(userDTO);
		
		HttpSession session = request.getSession();
		session.setAttribute("user", userDTO);
		session.setMaxInactiveInterval(1800);
		
		response.sendRedirect("/");

	}

}
