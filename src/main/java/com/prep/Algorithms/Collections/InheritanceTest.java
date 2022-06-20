package com.prep.Algorithms.Collections;

public class InheritanceTest {

	public static void main(String[] args) {
		X x1 = new A();
		X x2 = new I();
		System.out.println(x1.getSomeProp());
		System.out.println(x2.getSomeProp());

	}
}

class X {
	public String getSomeProp() {
		return "class X";
	}
}
class I extends X {
	/*@Override
	public String getSomeProp() {
		return "class I";
	}*/
}

class A extends I{
	int x;

	@Override
	public String getSomeProp() {
		return "class A";
	}
	
}
