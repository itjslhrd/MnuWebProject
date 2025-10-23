package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Exam04Servlet
 */
@WebServlet("/exam04.do")
public class Exam04Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Exam04Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Map<Key, Value>
		Map<Integer, String> sMap = new HashMap();
		//Map에 저장
		sMap.put(1, "김학생");
		sMap.put(2, "이학생");
		sMap.put(3, "박학생");
		sMap.put(4, "김학생");
		sMap.put(5, "이학생");
		sMap.put(3, "박홍생");
		
		request.setAttribute("sMap", sMap);
		
		RequestDispatcher rd = request.getRequestDispatcher("exam04.jsp");
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
