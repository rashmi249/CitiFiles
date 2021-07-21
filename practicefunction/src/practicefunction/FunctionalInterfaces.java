package practicefunction;

public class FunctionalInterfaces {

	public static void main(String[] args) {
		
		Adders operation= (x,y) -> x+y;
		
		System.out.println(operation.add(7, 8));
		
		

	}

}


interface Adders{

	public int add(int x,int y);
	
}