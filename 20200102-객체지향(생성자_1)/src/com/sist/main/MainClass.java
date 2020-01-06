package com.sist.main;
import com.sist.board.Board;
/*
 *    public     (protected  default)  private (자신의 클래스)
 *                 같은 폴더(패키지)
 *                => 상속 => 다른 패키지도 접근 가능 (protected)
 *    =====================================================
 *    모든 클래스 
 */
public class MainClass {

	 public static void main(String[] args) {
		// TODO Auto-generated method stub
        Board b=new Board(1,"게시판","2020-01-02");
        b.boardList();
	}

}
