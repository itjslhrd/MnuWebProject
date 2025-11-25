package servlet.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.user.UserDAO;
import model.user.UserDTO;
import util.UserSHA256;

/**
 * Servlet implementation class UserModifyServlet
 */
@WebServlet("/User/user_modify.do")
public class UserModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//회원수정폼
		RequestDispatcher rd = request.getRequestDispatcher("user_modify.jsp");
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
		dto.setPasswd(UserSHA256.getSHA256(request.getParameter("passwd")));
		dto.setTel(request.getParameter("tel"));
		
		UserDAO dao = UserDAO.getInstance();
		
		int row = dao.userModify(dto);
		
		HttpSession session = request.getSession();
		session.setAttribute("user", dto);
		session.setMaxInactiveInterval(1800);
		
		response.sendRedirect("/index.do");
		
	}

}
