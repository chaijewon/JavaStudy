import java.util.Arrays;

public class �ݺ���5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] arr= {20,10,30,50,40};
        //System.out.println("������");
        Arrays.sort(arr);
		/*
		 * for(int i=0;i<arr.length-1;i++) { for(int j=i;j<arr.length;j++) {
		 * if(arr[i]>arr[j]) { int temp=arr[i]; arr[i]=arr[j]; arr[j]=temp; } } }
		 */
        for(int i=0;i<arr.length;i++)
        {
        	System.out.print(arr[i]+" ");
        }
	}

}
