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
 * Servlet implementation class MemberSearchServlet
 */
@WebServlet("/member_search.do")
public class MemberSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("member_search.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//db 연결
		ShopDAO dao = new ShopDAO();
		
		//넘어온 값 받기
		int custno = Integer.parseInt(request.getParameter("custno"));
		//메소드 호출
		MemberDTO dto = dao.memberSearch(custno);
		
		// 값 저장
		request.setAttribute("dto", dto);
		
		RequestDispatcher rd = request.getRequestDispatcher("member_search.jsp");
		rd.forward(request, response);	
	}

}
