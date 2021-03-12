package boardApp;

public class Member {

	int num; 
	String loginId; 
	String loginPw;
	String nickname;

	public Member(int num, String loginId, String loginPw, String nickname) {
		this.num = num; // 대입 연산		
		this.loginId = loginId;
		this.loginPw = loginPw;
		this.nickname = nickname;
	}

}
