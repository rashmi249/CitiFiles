
public class A {
	
   void method1(String s) {
		System.out.println("1");
	}

}


class B extends A{

	public void method1(String s) {
		System.out.println("2");
		super.method1(null);
	}
	
}