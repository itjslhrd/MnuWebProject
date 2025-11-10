package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StudentDAO;
import model.StudentDTO;

/**
 * Servlet implementation class StudentModifyServlet
 */
@WebServlet("/student_modify.do")
public class StudentModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentDAO dao = new StudentDAO();
		String syear = request.getParameter("syear");
		String sclass = request.getParameter("sclass");
		String sno = request.getParameter("sno");
		
		StudentDTO dto = dao.studentSelect(syear,sclass,sno);
		
		request.setAttribute("dto", dto);
		
		RequestDispatcher rd = request.getRequestDispatcher("student_modify.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 수정처리
		StudentDAO dao = new StudentDAO();
		
		StudentDTO dto = new StudentDTO();
		
		dto.setSyear(request.getParameter("syear"));
		dto.setSclass(request.getParameter("sclass"));
		dto.setSno(request.getParameter("sno"));
		//dto.setSname(request.getParameter("sname"));
		dto.setBirth(request.getParameter("birth"));
		dto.setGender(request.getParameter("gender"));
		dto.setTel1(request.getParameter("tel1"));
		dto.setTel2(request.getParameter("tel2"));
		dto.setTel3(request.getParameter("tel3"));

		int row = dao.studentModify(dto);
		if(row==1) {
			response.sendRedirect("student_list.do");
		}else {
			response.sendRedirect("student_modify.do");
		}
	}

}
