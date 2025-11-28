package kr.ac.mnu.exsample.service.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.mnu.exsample.service.Action;

public class AdminLoginService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		// Filter 미 적용시 필요
		String url="/Admin/notice_list.jsp";
		if(request.getSession().getAttribute("admin")==null) {
			url = "/AdminLogin/admin_login.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
		*/	
	}

}
