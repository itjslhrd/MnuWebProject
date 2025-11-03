package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ArtistDTO;
import model.AuditionDAO;

/**
 * Servlet implementation class ArtistWriteServlet
 */
@WebServlet("/artist_write.do")
public class ArtistWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArtistWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("artist_write.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//DB 연결
		AuditionDAO dao = new AuditionDAO();
		ArtistDTO dto = new ArtistDTO();
		
		request.setCharacterEncoding("utf-8");
		
		dto.setArtist_id(request.getParameter("artist_id"));
		dto.setArtist_name(request.getParameter("artist_name"));
		dto.setArtist_birth(request.getParameter("birth1") + 
				request.getParameter("birth2") + 
				request.getParameter("birth3"));
		dto.setArtist_gender(request.getParameter("artist_gender"));
		dto.setTalent(request.getParameter("talent"));
		dto.setAgency(request.getParameter("agency"));
		
		int row = dao.artistWrite(dto);
		
		if(row == 0) {
			response.sendRedirect("artist_write.do");
		}else {
			response.sendRedirect("index.do");
		}
		
		//RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		//rd.forward(request, response);
		
	}

}
