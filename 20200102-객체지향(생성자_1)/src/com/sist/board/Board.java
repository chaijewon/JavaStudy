package com.sist.board;
/*
 *   java
 *   javax
 */
public class Board {
   int no;
   String name;
   String regdate; // default => ���� ����
   public Board(int no,String name,String regdate)
   {
	   this.no=no;
	   this.name=name;
	   this.regdate=regdate;
   }
   public void boardList()
   {
	   System.out.println("��ȣ:"+no);
	   System.out.println("�̸�:"+name);
	   System.out.println("�����:"+regdate);
   }
}
