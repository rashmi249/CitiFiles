package codepractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ElementReductionHacker {

	public static void main(String[] args) {
		List<Integer> list= Arrays.asList(1,2,3);
		int z= list.get(0);
		int x=0;
		for(int i=1;i<list.size();i++) {
				z = z+list.get(i); 

				x=x+z; 
			}
			
			//1 3 5
			
			System.out.println(x);
			
		}
		

	

}
