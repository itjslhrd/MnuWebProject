package servlet.notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.notice.NoticeDAO;
import model.notice.NoticeDTO;

/**
 * Servlet implementation class NoticeViewServlet
 */
@WebServlet("/Notice/notice_view.do")
public class NoticeViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		NoticeDAO dao = NoticeDAO.getInstance();
		
		//쿠키를 이용한 조회수 증가
		//쿠키검사
		boolean bool = false;
		Cookie info = null;
		Cookie[] cookies = request.getCookies();
		for(int x=0; x<cookies.length; x++) {
			info = cookies[x];
			if(info.getName().equals("mnuNotice"+idx)) {
				bool = true;
				break;
			}
		}
		// 쿠키에서 사용할 값 설정
		String newValue=""+System.currentTimeMillis();
		if(!bool) {//쿠키가 존재하지 않으면
			dao.noticeHits(idx);;//조회수 증가 메소드
			info = new Cookie("mnuNotice"+idx,newValue);//쿠키생성
			info.setMaxAge(60*60);//1시간 (24*60*60)-> 1일
			response.addCookie(info);//쿠키전용
		}
		
		NoticeDTO nDto = dao.noticeSelect(idx);
		nDto.setContents(nDto.getContents().replace("\n", "<br>"));
		
		request.setAttribute("nDto", nDto);
		
		RequestDispatcher rd = request.getRequestDispatcher("/Notice/notice_view.jsp");
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
