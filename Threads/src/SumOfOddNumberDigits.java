
public class SumOfOddNumberDigits {

	public static void main(String[] args) {
	 int num=12345;
	 int numb=num;
	 int n=0;
	 int sum=0;
	 int num1=numb;
	 int rev=0;
//	 String numb= String.valueOf(num);
//	 
//	 
//	 int sum = 0;
//	 for(int  i=0;i<numb.length();i++) {
//		
//		 if((i%2==0)) {
//			 sum = sum + (numb.charAt(i)-'0');
//			
//		 }
//		
//		 
//	 }
//	
//    System.out.println(sum);
//	}
	 
	 //First Find the length of number
	 int k=0;
	 while(num>0) { 
		 num= num/10;
		 k++;
	 }
	 
	 //odd
	 while(numb>0) {
		 n= numb%10;
		 if((k-1)%2!=0) {
		 sum=sum+n; 
		 }
		 numb=numb/10;
		 k--;
		 
	 }

	 while(num1>0) {
		 rev= (rev*10)+(num1%10); //0+5      
		                          //5*10 +4     
		                          //54*10+3  543
		                          //
	
	 num1= num1/10;

		 
	 }
	 

		/*
		 * int i=0; while(num>0) { n = num % 10; sum=sum+n; num= num/10; i++; }
		 */
//01234
//12345
//54321
	 
	 //odd 2+4
	 //odd 4+2
System.out.println(rev);
	
	}

}
