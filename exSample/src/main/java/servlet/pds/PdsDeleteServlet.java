package servlet.pds;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.pds.PdsDAO;

/**
 * Servlet implementation class PdsDeleteServlet
 */
@WebServlet("/Pds/pds_delete.do")
public class PdsDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PdsDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		request.setAttribute("idx", idx);
		
		RequestDispatcher rd = request.getRequestDispatcher("pds_delete.jsp");
		rd.forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		String pass = request.getParameter("pass");
		
		PdsDAO dao = PdsDAO.getInstance();
		
		//idx에 해당하는 첨부파일 유무 검사
		String filename = dao.pdsFileSearch(idx);
		
		int row = dao.pdsDelete(idx,pass);
		
		if(row==1) {
			//파일 삭제
			ServletContext context = getServletContext();
			String path = context.getRealPath("Pds/upload/");
			File file = new File(path + filename);
			if(file.exists()) {//파이이 존재하면 삭제
				file.delete();
			}
		}
		
		request.setAttribute("row", row);
		
		RequestDispatcher rd = request.getRequestDispatcher("pds_delete_pro.jsp");
		rd.forward(request, response);	
	}

}
