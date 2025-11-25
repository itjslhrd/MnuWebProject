package servlet.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.user.UserDAO;
import model.user.UserDTO;
import util.UserSHA256;

/**
 * Servlet implementation class UserWriteServlet
 */
@WebServlet("/User/user_write.do")
public class UserWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//회원가입폼
		RequestDispatcher rd = request.getRequestDispatcher("user_insert.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		UserDTO dto = new UserDTO();
		
		dto.setName(request.getParameter("name"));
		dto.setUserid(request.getParameter("userid"));
		
		String pass = request.getParameter("passwd");
		dto.setPasswd(UserSHA256.getSHA256(pass));//비밀번호 암호화
		
		dto.setTel(request.getParameter("tel"));
		
		UserDAO dao = UserDAO.getInstance();
		
		int row = dao.userWrite(dto);
		
		if(row==1) {
			//가입성공시
			response.sendRedirect("user_login.do");//로그인 폼
		}else {
			//가입실패시
			response.sendRedirect("user_write.do");//가입폼
		}
		
	}

}
