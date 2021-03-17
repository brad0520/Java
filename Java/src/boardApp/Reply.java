package boardApp;

public class Reply {
	
	private int id; // 댓글 식별 번호 (reply Id)
	private int articleId; // 댓글을 작성한 글 번호
	private String body; // 댓글 내용
	private String nickname; // 댓글 작성자
	private String regDate; // 댓글 작성일

	public Reply(int id, int articleId, String body, String nickname, String regDate) {
		this.id = id;
		this.articleId = articleId;
		this.body = body;
		this.nickname = nickname;
		this.regDate = regDate;
	}

	public int getid() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}

	public int getarticleId() {
		return articleId;
	}

	public void setarticleId(int articleId) {
		this.articleId = articleId;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
}
