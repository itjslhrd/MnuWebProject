package kr.ac.mnu.exsample.controller.user;

import kr.ac.mnu.exsample.service.Action;
import kr.ac.mnu.exsample.service.user.UserIdCheckService;
import kr.ac.mnu.exsample.service.user.UserLoginProService;
import kr.ac.mnu.exsample.service.user.UserLoginService;
import kr.ac.mnu.exsample.service.user.UserLogoutService;
import kr.ac.mnu.exsample.service.user.UserModifyProService;
import kr.ac.mnu.exsample.service.user.UserModifyService;
import kr.ac.mnu.exsample.service.user.UserWriteProService;
import kr.ac.mnu.exsample.service.user.UserWriteService;

public class UserServiceFactory {
	//싱글톤
	private UserServiceFactory() {}
	private static UserServiceFactory instance = new UserServiceFactory();
	public static UserServiceFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String cmd) {
		Action action = null;
		if(cmd.equals("user_write")) {//회원가입
			action = new UserWriteService();
		}else if(cmd.equals("user_write_pro")) {//회원가입처리
			action = new UserWriteProService();
		}else if(cmd.equals("user_modify")) {//회원정보수정
			action = new UserModifyService();
		}else if(cmd.equals("user_modify_pro")) {//회원정보수정처리
			action = new UserModifyProService();
		}else if(cmd.equals("user_login")) {//회원로그인 폼
			action = new UserLoginService();
		}else if(cmd.equals("user_idCheck")) {//아이디 중복검사
			action = new UserIdCheckService();			
		}else if(cmd.equals("user_login_pro")) {//회원로그인 처리
			action = new UserLoginProService();			
		}else if(cmd.equals("user_logout")) {//회원로그아웃
			action = new UserLogoutService();
		}
		
		return action;
	}
}
