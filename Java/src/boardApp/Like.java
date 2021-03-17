package boardApp;

public class Like {
	private int id; // 좋아요 식별 번호 (like id)
	private int parentId; // 좋아요를 체크한 글 번호 (article Id)
	private int memberId; // 로그인한 맴버 아이디 (member Id)
	private String regDate; // 좋아요 체크 날짜
	
	public Like() {
	}
	
	public Like(int parentId, int memberId) {
		this.parentId = parentId;
		this.memberId = memberId;
	}
	
	public Like(int parentId, int memberId, String regDate) {
		this.parentId = parentId;
		this.memberId = memberId;
		this.regDate = regDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
}
