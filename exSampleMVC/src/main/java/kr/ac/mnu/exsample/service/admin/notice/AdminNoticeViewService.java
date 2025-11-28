package kr.ac.mnu.exsample.service.admin.notice;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.mnu.exsample.model.notice.NoticeDAO;
import kr.ac.mnu.exsample.model.notice.NoticeDTO;
import kr.ac.mnu.exsample.service.Action;

public class AdminNoticeViewService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeDAO dao = NoticeDAO.getInstance();
				
		RequestDispatcher rd = request.getRequestDispatcher("/Admin/notice_view.jsp");
		rd.forward(request, response);

	}

}
