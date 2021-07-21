package serialstreampack;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestFilterData {

	public static void main(String[] args) {
	Stream<Integer> integerStream = Stream.of(1,2,3,4,5,5,6,7,8,9,10);
	
	System.out.println(integerStream);
	
	//filter data and print
	List<Integer> integerStream2 = integerStream.skip(2)
			.filter((Integer i) -> {
				System.out.println("In Filter");
				return i%2==0;
			}).
			map((Integer i) ->{
				System.out.println("In Map " + i);
				return i*i;
			})
			.limit(3)
		//	.sorted((Integer i1,Integer i2) -> i2-i1 )
			.sorted(Comparator.reverseOrder())
			.collect(Collectors.toList());

	
	System.out.println("list    "+ integerStream2);
	}

}
