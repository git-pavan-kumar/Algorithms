package com.prep.Algorithms.Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class ListPractice {

	public static void main(String[] args) {
		Employee e1 = new Employee(1, "USA", "nameUsaabc", 50);
		Employee e2 = new Employee(2, "India", "nameIndiaxyz", 60);
		Employee e3 = new Employee(3, "USA", "nameUsaxyz", 65);
		
		List<Employee> empList = new ArrayList<>();
		List<Employee> empLinkedList = new LinkedList<>();
		empList.add(e1);
		empList.add(e2);
		empList.add(e3);
		
		empLinkedList.add(e1);
		empLinkedList.add(e2);
		empLinkedList.add(e3);

		List<Employee> synList = Collections.synchronizedList(empList);
		List<Employee> cpyList = new CopyOnWriteArrayList<>(empList);
		
		/*Map<Employee, Integer> hset = new HashMap<>();
		hset.entrySet().;
		Object o;
		Comparator.reverseOrder();
		*/
		empList.stream()
				.filter(e -> e.getLocation().equals("USA"))
				//.map(e -> e.getName())
				.collect(Collectors.toList())
				.forEach(e -> System.out.println("USA employee: " + e.toString()));
		
		empList.stream()
				.filter(e -> (e.getAge() > 50))
				.forEach(System.out::print);
		
		empList.stream()
				.sorted(new Comparator<Employee>() {
					@Override
					public int compare(Employee e1, Employee e2) {
						return e1.getLocation().compareTo(e2.getLocation());
					}
				})
				.forEach(System.out::print);
	}
}

class ThreadRunner extends Thread {
	
	private List<Employee> eList;
	
	public ThreadRunner(List<Employee> eList) {
		this.eList = eList;
	}
	
	@Override
	public void run() {
		Iterator itr = eList.iterator();
		itr.remove();
	}
	
}

class Employee {
	private Integer empId;
	private String location;
	private String name;
	private Integer age;
	
	public Employee(Integer empId, String location, String name, Integer age) {
		this.empId = empId;
		this.location = location;
		this.name = name;
		this.age = age;
	}
	
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
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
		builder.append("Employee [empId=");
		builder.append(empId);
		builder.append(", location=");
		builder.append(location);
		builder.append(", name=");
		builder.append(name);
		builder.append(", age=");
		builder.append(age);
		builder.append("]");
		return builder.toString();
	}
	
}