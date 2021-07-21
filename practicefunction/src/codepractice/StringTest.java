package codepractice;

import java.util.HashSet;

public class StringTest {

	public static void main(String[] args) {
		String s1 =new String("Dinesh");
		String s2 =new String("Dinesh");
		
		HashSet s  = new HashSet();
		s.add(s1);
		s.add(s2);
		System.out.println(s);
		
	}

}
