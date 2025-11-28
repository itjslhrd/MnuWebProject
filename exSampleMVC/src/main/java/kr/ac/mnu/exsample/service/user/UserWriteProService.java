package kr.ac.mnu.exsample.service.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.mnu.exsample.model.user.UserDAO;
import kr.ac.mnu.exsample.model.user.UserDTO;
import kr.ac.mnu.exsample.service.Action;
import kr.ac.mnu.exsample.util.UserSHA256;

public class UserWriteProService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDTO userDTO = new UserDTO();
		
		userDTO.setName(request.getParameter("name"));
		userDTO.setUserid(request.getParameter("userid"));
		
		String pass = request.getParameter("passwd");
		userDTO.setPasswd(UserSHA256.getSHA256(pass));//비밀번호 암호화
		
		userDTO.setTel(request.getParameter("tel"));
		
		UserDAO userDAO = UserDAO.getInstance();
		
		int row = userDAO.userWrite(userDTO);
		
		request.setAttribute("row", row);

		RequestDispatcher rd = request.getRequestDispatcher("/User/user_insert_pro.jsp");
		rd.forward(request, response);

	}

}
