package boardApp;

class BoardApp extends Controller {


	static Member loginedMember = null;
	MemberController mc = new MemberController();
	ArticleController ac = new ArticleController();

	public void start() {

		while (true) {
			if (loginedMember != null) {
				System.out.println("명령어를 입력해주세요[" + loginedMember.loginId + "(" + loginedMember.nickname +")] :");				
			} else {
				System.out.println("명령어를 입력해주세요 :");								
			}

			String command = sc.next();

			if (command.equals("exit")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} if (command.equals("help")) {
				printHelp();

			}

			ac.doCommand(command);

			mc.doCommand(command);

		}
	}
	//=================================================================
	public void printHelp() {
		System.out.println("========================");
		System.out.println("help : 도움말");
		System.out.println("add : 데이터 추가");
		System.out.println("list : 데이터 조회");
		System.out.println("read : 게시물 상세 보기");
		System.out.println("update : 데이터 수정");
		System.out.println("delete : 데이터 삭제");
		System.out.println("exit : 프로그램 종료");
		System.out.println("signup : 회원가입");
		System.out.println("========================");
	}
}
