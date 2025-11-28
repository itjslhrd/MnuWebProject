package kr.ac.mnu.exsample.service.admin.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.mnu.exsample.model.board.BoardDAO;
import kr.ac.mnu.exsample.model.board.BoardDTO;
import kr.ac.mnu.exsample.service.Action;
import kr.ac.mnu.exsample.util.PageIndex;

public class AdminBoardListService implements Action{
	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO boardDAO = BoardDAO.getInstance();
		
		String search="",key="";
		int totcount = 0; // 게시글 총수
		if(request.getParameter("key") != null) {
			search = request.getParameter("search");
			key = request.getParameter("key");
			totcount = boardDAO.boardCount(search, key);
		}else {
			totcount = boardDAO.boardCount();	
		}
		
		int nowpage= 1;   // 현재 페이지
		int maxlist= 10;  // 페이지당 글 수
		int totpage = 1;  //총 페이지수		
		
		if(totcount%maxlist == 0 ) {
			totpage=totcount/maxlist;
		}else{
			totpage=totcount/maxlist+1;
		}
		
		if(request.getParameter("page") != null) {
			nowpage=Integer.parseInt(request.getParameter("page"));
		}
/*		
		int pagestart=(nowpage-1)*maxlist+1;
		int endpage=nowpage*maxlist;
		int listcount = totcount-((nowpage-1)*maxlist);
*/		
		//mysql 용
		int pagestart = (nowpage-1) * maxlist;        // 총 리스트에서 현재페이지 시작번호 구하기
		int listcount = totcount - pagestart;         // 리스트 출력시 붙여줄 번호 생성
		
		List<BoardDTO> boardList = null;
		if(key.equals("")) {
			boardList = boardDAO.boardList(pagestart, maxlist);
		}else {
			boardList = boardDAO.boardList(pagestart,maxlist, search, key);
		}
		String pageSkip="";
		if(key.equals("")) {
			pageSkip = PageIndex.pageList(nowpage, totpage, "/Board?cmd=board_list", maxlist);
		}else {	
			pageSkip = PageIndex.pageListHan(nowpage, totpage, "/Board?cmd=board_list", maxlist,search, key);
		}
		request.setAttribute("totcount", totcount);
		request.setAttribute("boardList", boardList);
		request.setAttribute("listcount", listcount);
		request.setAttribute("page", nowpage);
		request.setAttribute("totpage", totpage);
		request.setAttribute("pageSkip", pageSkip);
		request.setAttribute("search", search);
		request.setAttribute("key", key);
		
		RequestDispatcher rd = request.getRequestDispatcher("/Admin/board_list.jsp");
		rd.forward(request, response);
	}

}
