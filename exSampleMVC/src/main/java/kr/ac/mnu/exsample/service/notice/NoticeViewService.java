package kr.ac.mnu.exsample.service.notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.mnu.exsample.model.notice.NoticeDAO;
import kr.ac.mnu.exsample.model.notice.NoticeDTO;
import kr.ac.mnu.exsample.service.Action;

public class NoticeViewService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		NoticeDAO noticeDAO = NoticeDAO.getInstance();
		
		NoticeDTO noticeDTO = noticeDAO.noticeSelect(idx);
		
		request.setAttribute("noticeDTO", noticeDTO);
		
		RequestDispatcher rd = request.getRequestDispatcher("/Notice/notice_view.jsp");
		rd.forward(request, response);
	}

}
