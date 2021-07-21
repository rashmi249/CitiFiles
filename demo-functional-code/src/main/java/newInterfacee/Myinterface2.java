package newInterfacee;

public interface Myinterface2 {

	public default void defaultMethod() {
		System.out.println("defaultMethod of Interface2");	
		}
		
		public static void staticMethod() {
			System.out.println("Static Method of Interface2");	
			}
		
		
}
