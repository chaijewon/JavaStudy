// ~VO (�������� Ŭ����) => ĸ��ȭ 
/*
 *    ���� : �б�,���� => �޼ҵ�ȭ ó�� 
 *    
 *    ��λ� (2019)
����6.7/10
���/��
2019.12.19 ����
128��, 12���̻������
(����) ������, �躴��
(�ֿ�) �̺���, ������, ������, ������, ����
���� 1����������6,789,642��
�����ϱⰶ��������
���ѹα� ���� ����� �ִ� �Ը��� ��λ� ���� �߻�.
���۽����� �糭�� �ѹݵ��� ���İ��� �ƺ��ȯ�� �ǰ�,
���� �� ��θ� �����ų �߰� ������ �����ȴ�.

      ���� �ʱ�ȭ 
      1) ������ 
      2) �ʱ�ȭ ���
         
      3) setter
      
      class A
      {
          static int a=10;
          static int b=20;
            static
	        {   for(int i=0;i<10;i++)
	            {
	               a=i;
	            }
	            b=
	        }
          
      }
 */
public class MovieVO {
   private String title;
   private double score;
   private String genre;
   private String regdate;
   private int time;
   private String grade;
   private String director;
   private String actor;
   private int showUser;
   private String story;
   
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double s) {
		score = s;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public int getShowUser() {
		return showUser;
	}
	public void setShowUser(int showUser) {
		this.showUser = showUser;
	}
	public String getStory() {
		return story;
	}
	public void setStory(String story) {
		this.story = story;
	}
	   
   
}
