package com.prep.Algorithms.mergeSort;

public class Test {

	public static void main(String[] args) {
		int a = 10;
        long b =a;
        //b = a;
        System.out.println(b == a);

        Parent c = new Child(2);
        c.print();
        
	}
}

class Parent {
	protected int i = 10;
	Parent(int i) {
		this.i = i;
	}
	
	protected void print() {
		System.out.println("Parent class ...");
	}
}

class Child extends Parent {
	
	Child(int i) {
		super(i);
		
	}
	protected void print() {
		System.out.println(i);
		i = 50;
		System.out.println(i);
	}
}
