import java.util.*;
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        ArrayList list = new ArrayList();
        // �̸� ��� 
        list.add("ȫ�浿"); // 0
        list.add("��û��"); // 1
        /*
         *  ===============
         *  add() // 2
         */
        list.add("�ڹ���"); // 3
        list.add("������"); // 4
        list.add("�̼���"); // 5
        
        // ����� ���� Ȯ�� 
        System.out.println("����� �ο�:"+list.size());
        
        // ��� 
        for(int i=0;i<list.size();i++)
        {
            String name=(String)list.get(i);
            System.out.println(name);
        }
        /*
         *     list.add("ȫ�浿"); // 0
               list.add("��û��"); // 1
               list.add("�ڹ���"); // 3
               list.add("������"); // 4
               list.add("�̼���"); // 5
         *    
         */
        System.out.println("========================");
        // �߰� 
        list.add("������");
        
        /*
         *     list.add("ȫ�浿"); // 0
               list.add("��û��"); // 1
               list.add("�ڹ���"); // 2
               list.add("������"); // 3
               list.add("�̼���"); // 4
               list.add("������"); // 5
         *    
         */
        // ��� 
        for(int i=0;i<list.size();i++)
        {
            String name=(String)list.get(i);
            System.out.println(name);
        }
        
        System.out.println("=======================");
        list.add(2,"�����");
        
        /*
         *     list.add("ȫ�浿"); // 0
               list.add("��û��"); // 1
               list.add(2,"�����"); // 2
               list.add("�ڹ���"); // 3
               list.add("������"); // 4
               list.add("�̼���"); // 5
               list.add("������"); // 6
         *    
         */
        // ��� 
        for(int i=0;i<list.size();i++)
        {
            String name=(String)list.get(i);
            System.out.println(name);
        }
        
        System.out.println("=======================");
        // ���� 
        list.remove(3);
        /*
         *     list.add("ȫ�浿"); // 0
               list.add("��û��"); // 1
               list.add(2,"�����"); // 2
               list.add("������"); // 3
               list.add("�̼���"); // 4
               list.add("������"); // 5
         *    
         */
        for(int i=0;i<list.size();i++)
        {
            String name=(String)list.get(i);
            System.out.println(name);
        }
        
        System.out.println("==========================");
        // ���� 
        list.set(4, "�̼��� ����");
        /*
         *     list.add("ȫ�浿"); // 0
               list.add("��û��"); // 1
               list.add(2,"�����"); // 2
               list.add("������"); // 3
               list.add("�̼��ż���"); // 4
               list.add("������"); // 5
         *    
         */
        for(int i=0;i<list.size();i++)
        {
            String name=(String)list.get(i);
            System.out.println(name);
        }
        
        System.out.println("=========================");
        // ���� �߻� 
        list.add(100);
        
        for(int i=0;i<list.size();i++)
        {
            String name=(String)list.get(i);
            System.out.println(name);
        }
	}

}





