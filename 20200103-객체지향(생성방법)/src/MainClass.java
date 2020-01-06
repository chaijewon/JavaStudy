
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 클래스 생성 
		Sawon s1=new Sawon();
		// 활용  ==> 값 설정 ==> setter
		s1.setSabun(1);
		s1.setName("홍길동");
		s1.setDept("개발부");
		s1.setLoc("서울");
		s1.setPay(3500);
		
		// 출력  ==> getter
		System.out.println("사번:"+s1.getSabun());
		System.out.println("이름:"+s1.getName());
		System.out.println("부서:"+s1.getDept());
		System.out.println("근무지:"+s1.getLoc());
		System.out.println("연봉:"+s1.getPay());
		
		/*
		 * s1=null; System.gc();
		 */
		
	}

}
