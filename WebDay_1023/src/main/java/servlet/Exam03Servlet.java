package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Exam03Servlet
 */
@WebServlet("/exam03.do")
public class Exam03Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Exam03Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//리스트 생성
		List<String> aList = new ArrayList<String>();
		//값 저장
		
		aList.add("김학생");
		aList.add("이학생");
		aList.add("박학생");
		aList.add("강학생");
		aList.add("홍학생");
		aList.add("홍학생");
		aList.add("홍학생");
		aList.add("홍학생");
		aList.add("홍학생");
		
		//넘기기
		request.setAttribute("aList",aList);
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("exam03.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
