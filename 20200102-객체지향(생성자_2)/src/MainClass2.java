/*
 *     1. �������� �ʱ�ȭ 
 *        = ������ 
 *        = setter
 */
class Music{
	private int mno;
	private String title;
	private String singer;
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public Music(int mno, String title, String singer) {
		this.mno = mno;
		this.title = title;
		this.singer = singer;
	}
	
	
}
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Music music=new Music(100,"���� ���� ���ο���","�ٺ�ġ");
        // ���� 
		/*
		 * music.setMno(100); music.setTitle("���� ���� ���ο���"); music.setSinger("�ٺ�ġ");
		 */
        
        // �б�
        System.out.println(music.getMno());
        System.out.println(music.getTitle());
        System.out.println(music.getSinger());
        
        music=new Music(101,"���� ���� ���ο���1","�ٺ�ġ1");
        
		/*
		 * music.setMno(101); music.setTitle("���� ���� ���ο���"); music.setSinger("�ٺ�ġ");
		 */
        
	}

}






