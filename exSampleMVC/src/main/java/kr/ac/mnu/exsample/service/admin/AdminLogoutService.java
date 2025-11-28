package kr.ac.mnu.exsample.service.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.mnu.exsample.service.Action;

public class AdminLogoutService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//세션확인
		HttpSession session = request.getSession();
		session.invalidate();//세션해제
		//로그아웃
		response.sendRedirect("/");

	}

}
