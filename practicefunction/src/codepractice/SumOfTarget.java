package codepractice;

public class SumOfTarget {

	public static void main(String[] args) {
		int arr[] = {2,8,11,89,7,5};
	int	target=13;
	int result[] = new int[2];
	
	for(int i=0;i<arr.length;i++) {
		for(int j=i+1;j<arr.length;j++) {
			if(arr[i]+arr[j]==target) {
				result[0]=i;
				result[1]=j;
				break;
			}
		}
	}
	
	for(int i=0;i<result.length;i++) {
		System.out.println(result[i]);
	}
	}

}
