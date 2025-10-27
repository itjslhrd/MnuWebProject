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
 * Servlet implementation class StudentWriteOk
 */
@WebServlet("/student_write_ok.do")
public class StudentWriteOk extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentWriteOk() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//DB 연결
		StudentDAO dao = new StudentDAO();
		StudentDTO dto = new StudentDTO();
		
		//데이터 받기
		String hakbun = request.getParameter("hakbun");
		String name = request.getParameter("name");
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		String gender = request.getParameter("gender");
		
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String birth = year+month+day;
		
		String regdate = request.getParameter("regdate");
		//출력 테스트
		System.out.println("생년월일 : " + birth);
		
		dto.setHakbun(hakbun);
		dto.setName(name);
		dto.setPhone1(phone1);
		dto.setPhone2(phone2);
		dto.setPhone3(phone3);
		dto.setGender(gender);
		dto.setBirth(birth);
		dto.setRegdate(regdate);
		
		//DB저장
		int row = dao.studentWrite(dto);
		//테스트
		System.out.println("row : " + row);
		//결과 전송
		request.setAttribute("row", row);
		
		RequestDispatcher rd = request.getRequestDispatcher("index.html");
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
