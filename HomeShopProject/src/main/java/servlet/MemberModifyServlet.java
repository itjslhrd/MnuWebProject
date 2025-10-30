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
 * Servlet implementation class MemberModifyServlet
 */
@WebServlet("/member_modify.do")
public class MemberModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//수정폼
		//db 연결
		ShopDAO dao = new ShopDAO();
		
		int custno = Integer.parseInt(request.getParameter("custno"));
		
		MemberDTO dto = dao.memberSelect(custno);
		
		request.setAttribute("dto", dto);
		
		RequestDispatcher rd = request.getRequestDispatcher("member_modify.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//수정처리
		ShopDAO dao = new ShopDAO();
		// 값 받기
		MemberDTO dto = new MemberDTO();
		dto.setCustno(Integer.parseInt(request.getParameter("custno")));
		dto.setPhone(request.getParameter("tel1") + "-" + 
				request.getParameter("tel2") + "-" +
				request.getParameter("tel3"));
		dto.setGender(request.getParameter("gender"));
		dto.setGrade(request.getParameter("grade"));
		dto.setJoindate(request.getParameter("joindate"));
		dto.setCity(request.getParameter("city"));

		//수정 메소드 호출
		int row = dao.memberModify(dto);
		
		RequestDispatcher rd = request.getRequestDispatcher("index.html");
		rd.forward(request, response);
	}

}
