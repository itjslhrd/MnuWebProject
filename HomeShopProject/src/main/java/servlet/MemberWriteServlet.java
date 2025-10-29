package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDTO;
import model.ShopDAO;

/**
 * Servlet implementation class MemberWriteServlet
 */
@WebServlet("/member_write.do")
public class MemberWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("member_write.html");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//DB 연결
		ShopDAO dao = new ShopDAO();
		MemberDTO dto = new MemberDTO();
		
		//값 받기
		dto.setCustno(Integer.parseInt(request.getParameter("custno")));
		dto.setCustname(request.getParameter("custname"));
		dto.setPhone(request.getParameter("tel1")+
					request.getParameter("tel2")+
					request.getParameter("tel3"));
		dto.setGender(request.getParameter("gender"));
		dto.setJoindate(request.getParameter("joindate"));
		dto.setGrade(request.getParameter("grade"));
		dto.setCity(request.getParameter("city"));
		
		//db 저장
		int row=dao.memberWrite(dto);
		
		if(row==0) {
			response.sendRedirect("member_write.do");
		}else {
			//forword 등록 성공시
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.forward(request, response);
		}
	}

}
