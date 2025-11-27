package kr.ac.mnu.exsample.service.notice;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.mnu.exsample.model.notice.NoticeDAO;
import kr.ac.mnu.exsample.model.notice.NoticeDTO;
import kr.ac.mnu.exsample.service.Action;

public class NoticeListService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeDAO dao = NoticeDAO.getInstance();
/*		
		//전체 게시글수(검색없음)
		int totcount = dao.noticeCount();
		List<NoticeDTO> nList = dao.noticeList();
		
		request.setAttribute("totcount", totcount);
		request.setAttribute("nList", nList);
*/		
		//검색조건 포함
		String search="", key="";
		int totcount = 0;
		List<NoticeDTO> nList = null;
		if(request.getParameter("key") != null) {
			search = request.getParameter("search");
			key = request.getParameter("key");
			//int totcount = dao.noticeCount(search, key);
			//List<NoticeDTO> nList = dao.noticeList(search, key);
			//request.setAttribute("totcount", totcount);
			//request.setAttribute("nList", nList);
			totcount = dao.noticeCount(search, key);
			nList = dao.noticeList(search, key);
		}else {
			//int totcount = dao.noticeCount();
			//List<NoticeDTO> nList = dao.noticeList();
			//request.setAttribute("totcount", totcount);
			//request.setAttribute("nList", nList);
			totcount = dao.noticeCount();
			nList = dao.noticeList();
		}
		
		request.setAttribute("totcount", totcount);
		request.setAttribute("nList", nList);
		request.setAttribute("search", search);
		request.setAttribute("key", key);
				
		RequestDispatcher rd = request.getRequestDispatcher("/Notice/notice_list.jsp");
		rd.forward(request, response);
	}

}
