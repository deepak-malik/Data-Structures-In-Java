/**
 * Data-Structures-And-Algorithms-in-Java
 * HashCodeAndEquals.java
 */
package com.deepak.data.structures.Hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Implementation for HashCode and Equals contract
 * 
 * @author Deepak
 */
public class HashCodeAndEquals {

	/**
	 * Main method to start the flow
	 * @param args
	 */
	public static void main(String[] args) {
		Map<Employee, String> cache = loadEmployeeCache();
		Employee lookUpKey = new Employee("101", "10111992");
		String empName = cache.get(lookUpKey);
		System.out.println(empName);

		/**
		 * Set implementation 
		 */
		Set<Employee> employeeSet = new HashSet<>();
		Employee e1 = new Employee("100", "10111990");
		Employee e2 = new Employee("101", "10111992");
		Employee e3 = new Employee("101", "10111992");
		Employee e4 = new Employee("102", "10111991");
		Employee e5 = new Employee("102", "10111991");
		employeeSet.add(e1);
		employeeSet.add(e2);
		employeeSet.add(e3);
		employeeSet.add(e4);
		employeeSet.add(e5);
		System.out.println(employeeSet);
	}

	/**
	 * Method to load employee cache
	 */
	static Map<Employee, String> loadEmployeeCache() {
		Employee e1 = new Employee("100", "10111991");
		Employee e2 = new Employee("101", "10111992");
		Employee e3 = new Employee("102", "10111993");
		Map<Employee, String> cacheMap = new HashMap<>();
		cacheMap.put(e1, "Alice");
		cacheMap.put(e2, "Bob");
		cacheMap.put(e3, "Steve");
		return cacheMap;
	}

}

/**
 * Employee class
 * 
 * @author Deepak
 */
class Employee {
	String empId;
	String empDob;

	/**
	 * Constructor
	 * @param id
	 * @param dob
	 */
	public Employee(String id, String dob) {
		empId = id;
		empDob = dob;
	}

	/**
	 * HashCode implementation
	 */
	@Override
	public int hashCode() {
		int result = empId != null ? empId.hashCode() : 0;
		result = 31 * result + (empDob != null ? empDob.hashCode() : 0);
		return result;
	}

	/**
	 * Equals implementation
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Employee employee = (Employee) o;
		if (empDob != null ? !empDob.equals(employee.empDob) : employee.empDob != null) return false;
		if (empId != null ? !empId.equals(employee.empId) : employee.empId != null) return false;
		return true;
	}

	/**
	 * toString() implementation for printing
	 */
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empDob=" + empDob + "]";
	}

}
