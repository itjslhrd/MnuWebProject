package kr.ac.mnu.exsample.controller.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.mnu.exsample.service.Action;
import kr.ac.mnu.exsample.service.notice.NoticeListService;
import kr.ac.mnu.exsample.service.notice.NoticeViewService;

/**
 * Servlet implementation class NoticeController
 */
@WebServlet("/Notice")
public class NoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		System.out.println("NoticeController 호출됨 : " + cmd);
		
		Action action = null;
		if(cmd.equals("notice_list")) {
			action = new NoticeListService();
		}else if(cmd.equals("notice_view")) {
			action = new NoticeViewService();
		}
		
		action.process(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
