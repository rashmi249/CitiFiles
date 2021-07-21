package codepractice;

import java.util.Arrays;
import java.util.List;

public class SortStringArray {

	public static void main(String[] args) {
//	List<String> list = Arrays.asList("Abhi","Priya","Hina","Diya","Jiya","Maya");
		
	String[] str ={"Abhi","Priya","Hina","Diya","Jiya","Maya"};
	
	for(int i=0; i<str.length;i++) {
		
		for(int j=i+1; j<str.length;j++) {
			if(str[i].compareToIgnoreCase(str[j])>0) {
				String temp;
				temp = str[i] ;
				str[i]=str[j];
				str[j] =temp;
			}
		}
	}
	
	for (int k = 0; k < str.length; k++) {
		System.out.println(str[k]);
	}

	}

}
