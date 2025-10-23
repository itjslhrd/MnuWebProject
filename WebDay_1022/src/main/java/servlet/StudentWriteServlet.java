package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentWriteServlet
 */
@WebServlet("/studentWrite.do")
public class StudentWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//데이터 받기
		String syear = request.getParameter("syear");
		String sclass = request.getParameter("sclass");
		String sno = request.getParameter("sno");
		String sname = request.getParameter("sname");
		//생년월일
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String birth = year+"년"+month+"월"+day+"일";
		
		String gender = request.getParameter("gender");
		if(gender.equals("M")) {
			gender="남자";
		}else {
			gender="여자";
		}
		String tel1 = request.getParameter("tel1");
		String tel2 = request.getParameter("tel2");
		String tel3 = request.getParameter("tel3");
		
		//DB 저장
		
		//데이터 넘기기
		request.setAttribute("syear", syear);
		request.setAttribute("sclass", sclass);
		request.setAttribute("sno", sno);
		request.setAttribute("sname", sname);
		request.setAttribute("birth", birth);
		request.setAttribute("gender", gender);
		request.setAttribute("tel1", tel1);
		request.setAttribute("tel2", tel2);
		request.setAttribute("tel3", tel3);

		RequestDispatcher rd = request.getRequestDispatcher("student_write_ok.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
