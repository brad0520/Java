package boardApp;

public class Member {

	int id; // 멤버 식별 번호 (member Id)
	String loginId; // 로그인 시 입력한 아이디
	String loginPw; // 로그인 시 입력한 비밀번호
	String nickname; // 회원 닉네임

	public Member(int id, String loginId, String loginPw, String nickname) {
		this.id = id; // 대입 연산		
		this.loginId = loginId;
		this.loginPw = loginPw;
		this.nickname = nickname;
		
	}

	public int getid() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getLoginPw() {
		return loginPw;
	}

	public void setLoginPw(String loginPw) {
		this.loginPw = loginPw;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
}
