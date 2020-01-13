package com.sist.io2;
/*
 *     Thread�� ����ϴ� ��� 
 *     ====== �Ѱ��� �ϸ� ����ϰ� ����� 
 *     =================
 *       1. Runnable(interface) �̿��ϴ� ���
 *          => Ŭ���̾�Ʈ (������) 
 *          => run()�޼ҵ� ���� => ������ ����
 *          class A implements Runnable
 *       2. Thread�� ��ӹ޾Ƽ� ó�� 
 *          => Thread�� ������ Ȯ�� 
 *          class A extends Thread
 *          
 *     ===> �����ϴ� ��� 
 *     INIT(����:CREATED) ==> Runnable(���) ==> Running ==> �Ͻ�����
 *     =================
 *    Thread t1=new Thread()   t1.start()        run()  ==> sleep(),wait()
 *    Thread t2-new Thread()   t2.start()        run()  ==> sleep(),wait()
 *    => JVM 
 *       �̸��� �ο�  thread-0
 *       ���� �ο� (1~10)
 *       =============
 *         1 => MIN_PRIORITY
 *         10 => MAX_PRIORITY
 *         5  => NORM_PRIORITY
 *                                                     ==> ������ ����
 *                                                     interrupt(),join()
 *            
 */
class MyThread extends Thread
{
	public void run()
	{
		for(int i=1;i<=10;i++)
		{
			System.out.println(getName()+":"+i);
			try
			{
				Thread.sleep(50);
			}catch(Exception ex) {}
		}
	}
}
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName());
        // ����
		MyThread t1=new MyThread();
		MyThread t2=new MyThread();
		MyThread t3=new MyThread();
		
		t1.setName("ȫ�浿");
		t2.setName("��û��");
		t3.setName("�ڹ���");
		
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MIN_PRIORITY);
		t3.setPriority(Thread.MIN_PRIORITY);
		// �ʿ��� ������ ������ ����
		t1.start();
		t2.start();
		t3.start();
		
		// 1~10��� ���� 
		// t1.run(),t2,run(),t3.run()
		
	}

}





