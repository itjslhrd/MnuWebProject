package servlet.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.board.BoardDAO;
import model.board.BoardDTO;
import util.PageIndex;

/**
 * Servlet implementation class BoardListServlet
 */
@WebServlet("/Board/board_list.do")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//DB 연결
		//BoardDAO dao = new BoardDAO();
		BoardDAO dao = BoardDAO.getInstance();
		
		String search="", key="";
		String url="board_list.do";
		int totcount = 0; //총계시글 수
		if(request.getParameter("key") != null) {
			//post
			key = request.getParameter("key");
			search = request.getParameter("search");
			totcount = dao.boardCount(search, key);//검색조건에 맞는 게시글 수
		}else {
			//get
			totcount = dao.boardCount();
		}

		int nowpage=1;//현재 페이지
		int maxlist = 10;// 페이지당 글수
		int totpage=1;// 총페이지수

		//총페이지수 계산(totpage)
		if(totcount % maxlist == 0) {
			totpage = totcount / maxlist;
		}else {
			totpage = totcount / maxlist + 1;
		}
		
		if(request.getParameter("page") != null) {
			nowpage = Integer.parseInt(request.getParameter("page"));
		}
/*    oracle		
		int pagestart = (nowpage-1) * maxlist;
		int endpage =nowpage*maxlist;
		int listcount = totcount-((nowpage-1)*maxlist);
*/
		
		int pagestart = (nowpage-1) * maxlist;
		int listcount = totcount - pagestart;
		
		List<BoardDTO> bList = null;
		if(key.equals("")) {
			bList = dao.boardList(pagestart,maxlist);
		}else {
			bList = dao.boardList(pagestart, maxlist, search, key);
		}
		
		//페이처리 메소드 호출(PageIndex)
		String pageSkip="";
		if(key.equals("")) {
			pageSkip = PageIndex.pageList(nowpage, totpage, url, maxlist);
		}else {
			pageSkip = PageIndex.pageListHan(nowpage, totpage, url, maxlist, search, key);
		}
		
		request.setAttribute("totcount", totcount);//총게시글수
		request.setAttribute("totpage", totpage);//총페이지
		request.setAttribute("page", nowpage);//현재페이지
		request.setAttribute("listcount", listcount);//번호출력용

		request.setAttribute("search", search);//번호출력용
		request.setAttribute("key", key);//번호출력용
		
		request.setAttribute("bList", bList);
		request.setAttribute("pageSkip", pageSkip);
		
		RequestDispatcher rd = request.getRequestDispatcher("/Board/board_list.jsp");
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
