package com.sist.main;
import com.sist.board.Board;
/*
 *    public     (protected  default)  private (�ڽ��� Ŭ����)
 *                 ���� ����(��Ű��)
 *                => ��� => �ٸ� ��Ű���� ���� ���� (protected)
 *    =====================================================
 *    ��� Ŭ���� 
 */
public class MainClass {

	 public static void main(String[] args) {
		// TODO Auto-generated method stub
        Board b=new Board(1,"�Խ���","2020-01-02");
        b.boardList();
	}

}
