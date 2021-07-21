package functionalpak;

public class testLambdaExpression {

	//adder addf - (a+b) -> a+b ;
public static void mathCalculatot(Adder adderf) {
	int sum = adderf.add(10, 20);
	System.out.println("result=     "+ sum);
}
	public static void main(String[] args) {
	
		//Compiler inferece the data type for the parameter passedc as well as for return value
		Calculator<Integer, Float> callInt =(a,b) -> {
			return a+b;
		};

		//run def
		System.out.println(callInt.add(10, 20f));
		System.out.println(callInt.add(10, -20f));
		System.out.println(callInt.add(-10, -20f));
		System.out.println(callInt.add(new Integer(30),new Float(40)));
	
		
		//lambda expression with single value, remove the brackets
		
		MyFunctionalinterface<String> myfunc=s -> System.out.println("value -" + s.toUpperCase());
		myfunc.hello("Welcome to lambda");
		
		//returns a value
		Calculator<Integer, Float > calInt=(a,b) -> a+b;
		
		
		// If more than one statement
		
		Calculator<Integer,Float> calInt2=(a,b) -> {
			 System.out.println("value -");
return a+b;
		};
		
		mathCalculatot((a, b) ->  a+b );
		mathCalculatot((a, b) ->  a*b );
		mathCalculatot((a, b) ->  a/b );
		mathCalculatot((a, b) ->  a*b );
		

	}
	
	
	
}
	



