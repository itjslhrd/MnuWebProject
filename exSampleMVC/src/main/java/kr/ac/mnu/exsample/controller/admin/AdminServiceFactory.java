package kr.ac.mnu.exsample.controller.admin;

import kr.ac.mnu.exsample.service.Action;
import kr.ac.mnu.exsample.service.admin.AdminLoginProService;
import kr.ac.mnu.exsample.service.admin.AdminLoginService;
import kr.ac.mnu.exsample.service.admin.AdminLogoutService;
import kr.ac.mnu.exsample.service.admin.board.AdminBoardListService;
import kr.ac.mnu.exsample.service.admin.notice.AdminNoticeListService;

public class AdminServiceFactory {
	//싱글톤
	private AdminServiceFactory() {}
	private static AdminServiceFactory instance = new AdminServiceFactory();
	public static AdminServiceFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String cmd) {
		Action action = null;

		if(cmd.equals("admin_login")) {//관리자로그인
			action = new AdminLoginService();
		}else if(cmd.equals("admin_login_pro")) {//관리자로그인처리
			action = new AdminLoginProService(); 	
		}else if(cmd.equals("admin_logout")) {//관리자로그인아웃
			action = new AdminLogoutService(); 
		}else if(cmd.equals("notice_list")) {//공지목록
				action = new AdminNoticeListService();
		}else if(cmd.equals("notice_write")) {//공지등록
				//action = new AdminNoticeWriteService();
		}else if(cmd.equals("notice_write_pro")) {//공지등록처리
				//action = new AdminNoticeWriteProService();
		}else if(cmd.equals("board_list")) {//게시판목록
			action = new AdminBoardListService();
		}
		
		return action;
	}

}
