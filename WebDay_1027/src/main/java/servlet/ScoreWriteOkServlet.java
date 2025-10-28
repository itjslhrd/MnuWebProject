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
import model.StudentDTO;

/**
 * Servlet implementation class ScoreWriteOkServlet
 */
@WebServlet("/score_write_ok.do")
public class ScoreWriteOkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScoreWriteOkServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//DB연결
		StudentDAO dao = new StudentDAO();//DAO 객체 생성
		ScoreDTO dto = new ScoreDTO();//DTO 객체 생성
		
		//값 받기 request.getPXXXX()
		String hakbun = request.getParameter("hakbun");
		dto.setHakbun(hakbun);
		//dto.setHakbun(request.getParameter("hakbun"));
		
		//정수로 변환
		int kor = Integer.parseInt(request.getParameter("kor"));
		dto.setKor(kor);
		
		dto.setEng(Integer.parseInt(request.getParameter("eng")));
		dto.setMat(Integer.parseInt(request.getParameter("mat")));
		
		//DB 저장하기
		int row = dao.scoreWrite(dto);
		
		System.out.print("row : " + row);
		//전달 request.setXXXX()
		request.setAttribute("변수명", "값");
		
		//이동
		RequestDispatcher rd = request.getRequestDispatcher("index.html");
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
