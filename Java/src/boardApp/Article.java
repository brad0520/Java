package boardApp;

public class Article {

	private int id; // 게시판 글 식별 번호 (article Id)
	private String title; // 게시글 제목
	private String body; // 게시글 내용
	private String regDate; // 게시글 작성 일자
	private String nickname; // 게시글 작성자
	private int hit; // 게시글 조회수
	private int mid; // 
	private int likeCnt; // 게시글 좋아요 개수
	
	public Article () {
		
	}
	
	public Article (int id, String title, String body, String regDate, String nickname, int hit, int mid, int likeCnt) {
		super();
		this.id = id;
		this.title = title;
		this.body = body;
		this.regDate = regDate;
		this.nickname = nickname;
		this.hit = hit;
		this.mid = mid;
		this.likeCnt = likeCnt;
	}

	public String getPropertiesByFlag(int flag) {
		String str = "";
		if (flag == 1) {
			str = this.getTitle();
		} else if (flag == 2) {
			str = this.getBody();
		} else if (flag == 3) {
			str = this.getTitle() + this.getBody();
		} 
		return str;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public int getLikeCnt() {
		return likeCnt;
	}

	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
	}
	
}
