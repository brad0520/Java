package boardApp;

import java.util.ArrayList;

public class LikeDao {
	
	private static ArrayList<Like> likes;
	private static int no = 1;
	
	public LikeDao (){
		likes = new ArrayList<Like>();
	}
	
	public static void insertLike (Like like) {
		like.setId(no);
		no++;
		like.setRegDate(Util.getCurrentDate());
		likes.add(like);
	}
	
	public static void removeLike (Like rst) {

		likes.remove(rst);
	}
	
	public static void getLikeCnt(Article a1) {
		int cnt = 0;
		for (int i = 0; i<likes.size(); i++) {
			Like like = likes.get(i);
			if ( like.getParentId() == a1.getId()) { 
				cnt++;
			}
			a1.setLikeCnt(cnt);
		}
	}
	
	public Like getLikeByArticleIdAndMemberId(int aid, int mid) {
		
		for (int i = 0; i < likes.size(); i++) {
			Like like = likes.get(i);
			if (like.getParentId() == aid && like.getMemberId() == mid ) {
				return like;
			}
		}
		return null;
	}
	
}
