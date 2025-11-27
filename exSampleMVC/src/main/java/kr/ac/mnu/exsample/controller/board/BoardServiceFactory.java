package kr.ac.mnu.exsample.controller.board;

import kr.ac.mnu.exsample.service.Action;
import kr.ac.mnu.exsample.service.board.BoardDeleteProService;
import kr.ac.mnu.exsample.service.board.BoardDeleteService;
import kr.ac.mnu.exsample.service.board.BoardListService;
import kr.ac.mnu.exsample.service.board.BoardModifyProService;
import kr.ac.mnu.exsample.service.board.BoardModifyService;
import kr.ac.mnu.exsample.service.board.BoardViewService;
import kr.ac.mnu.exsample.service.board.BoardWriteService;

public class BoardServiceFactory {
	//싱글톤
	private BoardServiceFactory() {}
	private static BoardServiceFactory instance = new BoardServiceFactory();
	public static BoardServiceFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String cmd) {
		Action action = null;
		if(cmd.equals("board_list")) {//게시글 목록
			action = new BoardListService();
		}else if(cmd.equals("board_write")) {//글 등록
			action = new BoardWriteService();
		}else if(cmd.equals("board_write_pro")) {//글 등록처리
			//action = new BoardWriteProService();
		}else if(cmd.equals("board_view")) {
			action = new BoardViewService();
		}else if(cmd.equals("board_modify")) {
			action = new BoardModifyService();
		}else if(cmd.equals("board_modify_pro")) {
			action = new BoardModifyProService();
		}else if(cmd.equals("board_delete")) {
			action = new BoardDeleteService();
		}else if(cmd.equals("board_delete_pro")) {
			action = new BoardDeleteProService();
		}
		
		return action;
	}
}
