// ���� 
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Student s1=new Student();
        s1.setName("ȫ�浿");
        s1.setKor(89);
        s1.setEng(80);
        s1.setMath(90);
        Student s2=new Student();
        s2.setName("��û��");
        s2.setKor(80);
        s2.setEng(78);
        s2.setMath(100);
        Student s3=new Student();
        s3.setName("�̼���");
        s3.setKor(85);
        s3.setEng(89);
        s3.setMath(95);
        
        StudentSystem ss=new StudentSystem();
		/*
		 * s1.setTotal(ss.totalData(s1.getKor(), s1.getEng(), s1.getMath()));
		 * s1.setAvg(ss.avgData(s1.getTotal())); s1.setScore(ss.scoreData(s1.getAvg()));
		 */
        ss.hakjumData(s1);
        ss.hakjumData(s2);
        ss.hakjumData(s3);
        System.out.println("=============���============");
        System.out.println("�̸�:"+s1.getName());
        System.out.println("����:"+s1.getKor());
        System.out.println("����:"+s1.getEng());
        System.out.println("����:"+s1.getMath());
        System.out.println("����:"+s1.getTotal());
        System.out.println("���:"+s1.getAvg());
        System.out.println("����:"+s1.getScore());
        
		/*
		 * s2.setTotal(ss.totalData(s2.getKor(), s2.getEng(), s2.getMath()));
		 * s2.setAvg(ss.avgData(s2.getTotal())); s2.setScore(ss.scoreData(s2.getAvg()));
		 */
        
        System.out.println("=============���============");
        System.out.println("�̸�:"+s2.getName());
        System.out.println("����:"+s2.getKor());
        System.out.println("����:"+s2.getEng());
        System.out.println("����:"+s2.getMath());
        System.out.println("����:"+s2.getTotal());
        System.out.println("���:"+s2.getAvg());
        System.out.println("����:"+s2.getScore());
        
		/*
		 * s3.setTotal(ss.totalData(s3.getKor(), s3.getEng(), s3.getMath()));
		 * s3.setAvg(ss.avgData(s3.getTotal())); s3.setScore(ss.scoreData(s3.getAvg()));
		 */
        
        System.out.println("=============���============");
        System.out.println("�̸�:"+s3.getName());
        System.out.println("����:"+s3.getKor());
        System.out.println("����:"+s3.getEng());
        System.out.println("����:"+s3.getMath());
        System.out.println("����:"+s3.getTotal());
        System.out.println("���:"+s3.getAvg());
        System.out.println("����:"+s3.getScore());
	}

}
