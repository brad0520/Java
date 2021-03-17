package boardApp;

import java.util.Scanner;

public class Controller { // 모든 클래스에서 사용되는 변수, 메서드를 담은 클랙스
	
	// Scanner ============================================
	Scanner sc = new Scanner(System.in);

	// isLogin() ==========================================
	public boolean isLogin() {
		if (BoardApp.loginedMember == null ) {
			System.out.println("로그인 후 이용해주세요.");
			return false;
		} else {
			return true;
		}
	}
}
