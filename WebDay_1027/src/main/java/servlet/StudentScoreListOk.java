package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ScoreDTO;
import model.StudentDAO;

/**
 * Servlet implementation class StudentScoreListOk
 */
@WebServlet("/student_score_list_ok.do")
public class StudentScoreListOk extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentScoreListOk() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentDAO dao = new StudentDAO();
		
		String hakbun = request.getParameter("hakbun");
			
		ScoreDTO dto = dao.studentScoreList(hakbun);
		// 검색
		
		request.setAttribute("dto", dto);
				
		RequestDispatcher rd = request.getRequestDispatcher("student_score_list_ok.jsp");
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
