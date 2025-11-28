package kr.ac.mnu.exsample.service.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.mnu.exsample.service.Action;

public class AdminLoginProService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String adminid = request.getParameter("adminid");
		String adminpass = request.getParameter("adminpass");
		//하드코딩
		//db 연결 검색
		int row=0;//로그인(row =1 (성공), row=0(비번오류), row=-1(id오류)
		if(adminid.equals("admin") && adminpass.equals("4321")) {
			HttpSession session = request.getSession();
			session.setAttribute("admin", "홍길동");
			session.setMaxInactiveInterval(1800);//세션유지시간30분
			//String name = (String)session.getAttribute("admin");//세션값 
			row=1;
		}
		
		System.out.println("row=" + row);
		String url = "/AdminLogin/admin_login_pro.jsp";
		
		request.setAttribute("row", row);			
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
				
	}

}
