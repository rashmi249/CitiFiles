import java.util.HashSet;
import java.util.Set;

public class FindDuplicates {

	public static void main(String[] args) {
		int ar[] = {1,3,4,5,4,8,2,1,7};
		
		Set<Integer> set = new HashSet<Integer>();
		
		for(int a:ar) {
			if(!(set.add(a))){
			System.out.println(a);
			break;
			}
		}
	}

}
