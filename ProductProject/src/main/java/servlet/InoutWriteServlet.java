package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CompanyDTO;
import model.ProductDAO;

/**
 * Servlet implementation class InoutWriteServlet
 */
@WebServlet("/inout_write.do")
public class InoutWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InoutWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDAO dao = new ProductDAO();
		
		int t_no = dao.inoutMax();//메소드 호출
		if(t_no==0) {
			t_no = 20200001;
		}
		
		request.setAttribute("t_no", t_no);//입출고번호/ 값 넘기기
		
		List<CompanyDTO> list = dao.companyList();
		request.setAttribute("list", list);//거래처코드, 거래처이름
		
		RequestDispatcher rd = request.getRequestDispatcher("inout_write.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		
	}

}
