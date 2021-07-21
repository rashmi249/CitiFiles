package newInterfacee;

import java.util.Optional;

public class MyClassImpl implements MyInterface1,Myinterface2{

	@Override
	public Optional<String> greet(String name) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(name);
	}

	@Override
	public void defaultMethod() {
		// TODO Auto-generated method stub
		MyInterface1.super.defaultMethod();
	}

}
