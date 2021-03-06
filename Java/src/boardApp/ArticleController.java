package boardApp;

import java.util.ArrayList;
import java.util.Scanner;

public class ArticleController extends Controller {

	ArrayList<Article> articles = new ArrayList<Article>();
	ArrayList<Reply> replies = new ArrayList<Reply>();
	LikeDao likeDao = new LikeDao();

	int num = 4;
	int rNum = 1;

	MemberController mc = new MemberController();

	public ArticleController() {

		Article a1 = new Article(1, "안녕하세요", "안녕하세요", "2021.03.08", "익명", 30);
		Article a2 = new Article(2, "반갑습니다", "반갑습니다", "2021.03.08", "익명", 20);
		Article a3 = new Article(3, "안녕2", "안녕2", "2021.03.08", "익명", 10);

		articles.add(a1);
		articles.add(a2);
		articles.add(a3);
	}
	public void doCommand(String command) {

		if (command.equals("add")) {
			if(isLogin()) {
				addArticle(); // top 다운방식				
			}
		} else if (command.equals("list")) {
			printArticleList(articles);

		} else if (command.equals("update")) {
			if (isLogin()) {
				updateArticle();				
			}

		} else if (command.equals("delete")) {
			if (isLogin()) {
				deleteArticle();				
			}
		} else if (command.equals("search")) {
			searchArticle();

		} else if (command.equals("read")) {
			if (isLogin()) {
				readArticle();
			}
		}
	}
	// =================================================================
	public void searchArticle() {
		// 제목으로 검색
		// 게시물 제목, 검색키워드
		// 게시물제목.contains(검색키워드)
		System.out.println("검색 항목을 선택해주세요 (1. 제목, 2. 내용, 3. 제목 + 내용, 4. 작성자) : ");
		int searchFlag = sc.nextInt();
		System.out.println("검색 키워드를 입력해주세요 : ");
		String keyword = sc.next();

		ArrayList<Article> searchedArticles = new ArrayList<Article>();

		String searchTarget = "";

		for(int i = 0; i < articles.size(); i++) {

			Article article = articles.get(i);

			if(searchFlag == 1) {
				searchTarget = article.title; // 게시물 제목
			} else if(searchFlag == 2) {
				searchTarget = article.body;
			} else if(searchFlag == 3) {
				searchTarget = article.title + article.body; 
			}

			if(searchTarget.contains(keyword)) {
				searchedArticles.add(article);
			}
		}

		printArticleList(searchedArticles);

	}
	//=================================================================
	public void addArticle() {

		// 번호 저장 -> 중복 되어서는 안되는 데이터

		System.out.println("제목을 입력해주세요 : ");
		String title = sc.next();
		System.out.println("내용을 입력해주세요 : ");
		String body = sc.next();
		String regDate = Util.getCurrentDate();

		// Article class를 통해 알려준 게시물 저장소 만들어줘
		Article a1 = new Article(num, title, body, regDate, "익명", 0);
		articles.add(a1);

		num++;

		System.out.println("게시물이 등록되었습니다.");
	}
	//=================================================================
	// 전체 게시물을 받아서 출력해주는 메서드
	public void printArticleList(ArrayList<Article> articles) {
		System.out.println("======================");

		for(int i = 0; i < articles.size(); i++) {

			Article a1 = articles.get(i);
			System.out.println("번호 : " + a1.num);
			System.out.println("제목 : " + a1.title);
			System.out.println("등록일 : " + a1.regDate);
			System.out.println("작성자 : " + a1.nickname);
			System.out.println("조회수 : " + a1.hit);
			
			int likeCnt = LikeDao.getLikeCnt(target.getId());
			System.out.println("좋아요 : " + likeCnt);
			
			System.out.println("======================");
		}
	}
	//=================================================================
	// 전체 게시물을 받아서 출력해주는 메서드
	public void printArticle(Article a1) {
		System.out.println("======" + a1.num + "번 게시물======");
		System.out.println("번호 : " + a1.num);
		System.out.println("제목 : " + a1.title);
		System.out.println("내용 : " + a1.body);
		System.out.println("등록일 : " + a1.regDate);
		System.out.println("조회수 : " + a1.hit);
		
		int likeCnt = LikeDao.getLikeCnt(target.getId());
		System.out.println("좋아요 : " + likeCnt);
		
		System.out.println("작성자 : " + a1.nickname);
		System.out.println("======================");
	}
	//=================================================================
	// 특정 게시물의 index를 찾아주는 메서드
	public int getIndexOfArticle(int targetNum) {

		int targetIndex = -1;

		for(int i = 0; i < articles.size(); i++) {
			Article article = articles.get(i);
			if(article.num == targetNum) {
				targetIndex = i;
			}
		}

		return targetIndex; 
	}
	//=================================================================
	public void updateArticle() {
		System.out.println("몇번 데이터를 수정하시겠습니까? :");
		int targetNum = sc.nextInt();

		// 호출한 쪽으로 넣어주는 방법 : 인수 - 매개변수

		int targetIndex = getIndexOfArticle(targetNum); // 메서드를 사용(호출) 

		if(targetIndex == -1) {
			System.out.println("없는 게시물 번호입니다.!!");

		} else {
			// 수정 코드
			System.out.println("새제목 : ");
			String newTitle = sc.next();
			System.out.println("새내용 : ");
			String newBody = sc.next();

			Article article = articles.get(targetIndex);
			article.setTitle(newTitle);
			article.setBody(newBody);
		}

		printArticleList(articles);
	}
	//=================================================================
	public void readArticle() {
		System.out.println("상세보기할 게시물 번호를 입력해주세요 : ");
		int targetNum = sc.nextInt();

		// 호출한 쪽으로 넣어주는 방법 : 인수 - 매개변수

		int targetIndex = getIndexOfArticle(targetNum); // 메서드를 사용(호출) 

		if(targetIndex == -1) {
			System.out.println("없는 게시물 번호입니다.!!");

		} else {
			Article a1 = articles.get(targetIndex);
			printArticle(a1);
			readDetailArticle(a1);
			a1.setHit(a1.getHit() + 1);
		}
	}
	//=================================================================
	public void readDetailArticle(Article a1) {
		while (true) {
			System.out.println("상세보기 기능을 선택해주세요(1. 댓글 등록, 2. 좋아요, 3. 수정, 4. 삭제, 5. 목록으로) : ");
			int command = sc.nextInt();

			if (command < 1 || command > 5) {
				System.out.println("올바른 명령을 입력해주세요.");

			} else if (command == 1) {
				replyArticle(a1);
				break;

			} else if (command == 2) {
				
				if (isLogin()) { 
					
					Like rst = likeDao.getLikeByArticleIdAndMemberId(target.getId(), loginedMember.getId());
					
					if (rst == null) {
						Like like = new Like(target.getId(), loginedMember.getId());
						likeDao.insertLike(like);
						System.out.println("좋아요를 체크했습니다.");
					} else {
						likeDao.removeLike(rst);
						System.out.println("좋아요를 해제했습니다.");
					}
				}				
				
				break;

			} else if (command == 3) {
				updateArticle();
				break;

			} else if (command == 4) {
				deleteArticle();
				break;

			} else if (command == 5) {
				printArticleList(articles);
				break;
			}
		}
	}
	//=================================================================
	public void replyArticle(Article a1) {
		if (BoardApp.loginedMember ==null) {
			System.out.println("로그인 후 작성해주세요.");
			mc.loginMember();
		} else {
			System.out.println("댓글 내용을 입력해주세요 :");
			String newReply = sc.next();
			String regDate = Util.getCurrentDate();
			Reply reply = new Reply(rNum, a1.getId(), newReply, BoardApp.loginedMember.nickname, regDate);
			replies.add(reply);
			System.out.println("댓글이 등록되었습니다.");

			printArticle(a1);

			//		게시글별로 댓글이 관리가 되야하지 않을까? 
			//		그러면 게시글의 번호를 갖는 댓글만 먼저 정리하는 과정이 필요하지 않을지...
			System.out.println("=========댓글=========");
			for (int i=0; i<replies.size(); i++) {
				Reply r1 = replies.get(i);
				if(a1.num == r1.articleNum) {
					System.out.println("내용 : " + r1.body);
					System.out.println("작성자 : " + r1.nickname);
					System.out.println("작성일 : " + r1.regDate);
				}
			}
			System.out.println("====================");

			rNum++;
		}
	}
	//=================================================================
	public void deleteArticle() {

		System.out.println("몇번 데이터를 삭제하시겠습니까? :");
		int targetNum = sc.nextInt();
		int targetIndex = getIndexOfArticle(targetNum);

		if(targetIndex == -1) {
			System.out.println("없는 게시물 번호입니다.!!");
		} else {
			// 삭제 코드
			articles.remove(targetIndex);
		}
		printArticleList(articles);
	}
}
