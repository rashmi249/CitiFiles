import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortMapByValue {

	public static void main(String[] args) {
		Map<Integer,String> map= new HashMap<Integer,String>();
	   map.put(2, "B");
	   map.put(1, "A");
	   map.put(4, "D");
	   map.put(3, "C");
	   
	   Map<Integer,String>  map1 = map.entrySet()
 										.stream().sorted(Map.Entry.comparingByValue())
 										.collect(Collectors.toMap(Map.Entry<Integer,String>:: getKey, Map.Entry<Integer,String>::getValue, (e1,e2)-> e2, LinkedHashMap::new));
	   
	   for(Map.Entry<Integer, String> entry : map1.entrySet()) {
		   
		   System.out.println(entry.getKey()+ " "+ entry.getValue());
	   }

	}

}
