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

import model.PersonDTO;

/**
 * Servlet implementation class Exam05Servlet
 */
@WebServlet("/exam05.do")
public class Exam05Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Exam05Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//리스트 생성
		List<PersonDTO> pList = new ArrayList<PersonDTO>();
		pList.add(new PersonDTO(1,"김학생","M",80));
		pList.add(new PersonDTO(2,"이학생","M",70));
		pList.add(new PersonDTO(3,"박학생","F",90));
		pList.add(new PersonDTO(4,"강학생","F",85));
		pList.add(new PersonDTO(5,"홍학생","F",75));
		
		request.setAttribute("pList", pList);
		
		RequestDispatcher rd = request.getRequestDispatcher("exam05.jsp");
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
