/*
 *    break
 *    continue
 *    ========= ������ �ݺ����� ����
 *              break => for,do~while,while,switch~case
 *              continue => for,do~while,while
 *              return => � ����̵� ����� �����ϴ� 
 */
public class �ݺ���� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        for(int i=1;i<=3;i++)
        {
        	if(i==2)
           	 continue;
        	for(int j=1;j<=3;j++)
        	{
        		//if(j==2)
        			//continue;
        		System.out.println("i="+i+",j="+j);
        	}
        	
        }
	}

}







