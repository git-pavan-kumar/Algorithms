package com.prep.Algorithms.Collections;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class EqualsAndHashcodeTest {

	public static void main(String[] args) {
		Employees e1 = new Employees(1, "abc");
		Employees e2 = new Employees(1, "abc");
		
		System.out.println("Is e1 equal to e2 ? " + e1.equals(e2));
		System.out.println("Hash code of e1: "+ e1.hashCode());
		System.out.println("Hash code of e2: "+ e2.hashCode());
		
		e2.setName("xyz");
		System.out.println("Employee e1: "+ e1 + ", hashcode: " + e1.hashCode());
		System.out.println("Employee e2: "+ e2 + ", hashcode: " + e2.hashCode());
		Map<Employees, Integer> eMap = new HashMap<>();
		eMap.put(e1, Integer.valueOf(100));
		eMap.put(e2, Integer.valueOf(200));
		
		
		for(Map.Entry<Employees, Integer> emp :eMap.entrySet()) {
			System.out.println(emp.toString() + " " + emp.hashCode());
		}
		
		//eMap.values().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
	}
}

class Employees {
	private Integer eId;
	private String name;
	
	public Employees(Integer eId, String name) {
		super();
		this.eId = eId;
		this.name = name;
	}

	public Integer geteId() {
		return eId;
	}

	public void seteId(Integer eId) {
		this.eId = eId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employee [eId=");
		builder.append(eId);
		builder.append(", name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o)
			return true;
		if(!(o instanceof Employees))
			return false;
		Employees e = (Employees) o;
		if(this.eId == e.geteId() && this.eId.equals(e.getName())) 
			return true;
		return false;
	}
	
	@Override
	public final int hashCode() {
		int x = 31;
		if(this.eId > 0) {
			x = x * 17 + this.eId.hashCode();
		}
		if(this.name != null) {
			x = x * 17 + this.name.hashCode();
		}
		return x;
	}
}
