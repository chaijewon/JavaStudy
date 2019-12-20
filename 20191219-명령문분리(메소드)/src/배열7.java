
public class ¹è¿­7 {
	static void getData2(String s)
	{
		s="Hello";
	}
    static void getData(int[] arr)
    {
    	for(int i=0;i<arr.length;i++)
    	{
    		arr[i]=(int)(Math.random()*100)+1;
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String a="Java";
		getData2(a);
		System.out.println(a);
        int[] arr=new int[5];
        for(int i:arr)
        {
        	System.out.println(i);
        }
        getData(arr);
        for(int i:arr)
        {
        	System.out.println(i);
        }
	}

}
