package com.prep.Algorithms.Collections;

import java.util.PriorityQueue;
import java.util.Queue;

public class ComparatorPractise {

	private static class Employee {
		private int id;
		private String name;
		
		Employee(int id, String name) {
			this.id = id;
			this.name = name;
		}
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
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
			builder.append("Employee [id=");
			builder.append(id);
			builder.append(", name=");
			builder.append(name);
			builder.append("]");
			return builder.toString();
		}
	}
	public static void main(String[] args) {
		Employee e1 = new Employee(1, "abc");
		Employee e2 = new Employee(2, "def");
		Employee e3 = new Employee(3, "ghi");
		Employee e4 = new Employee(4, "xyz");
		
		//Set<Employee> s = new TreeSet<Employee>((x,y) -> y.getId() - x.getId());
		Queue<Employee> s = new PriorityQueue<Employee>((x,y) -> y.getId() - x.getId()); 
		s.add(e1);
		s.add(e2);
		s.add(e3);
		s.add(e4);
		
		System.out.println(s);
	}

}
