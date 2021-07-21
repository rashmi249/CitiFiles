package newInterfacee;

import java.util.Optional;

public interface MyInterface1 {

	public Optional<String> greet(String name);
	
	public default void defaultMethod() {
	System.out.println("defaultMethod of Interface1");	
	}
	
	public static void staticMethod() {
		System.out.println("Static Method of Interface1");	
		}
	
}
