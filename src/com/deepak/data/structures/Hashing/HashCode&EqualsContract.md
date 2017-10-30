## HashCode and Equals contract in Java
Each java object that we create has a parent class called Object which has default implementation for hashCode() and equals(). Therefore each java object inherits the default behaviour of hashCode() and equals().

#### Usage
hashCode() method is used to get unique integer representation for a object. This integer is a representation of memory address where this object will be stored. This is used to determine bucket location if we have to deal with hash tables whereas equals() method is used to check the equality of two objects. Default implementation simply checks the memory reference of two objects. 

Everything will work fine until you do not override these methods, but if you override one then ensure you override the second one as well. This is called contract between hashcode and equals. Both of them work hand in hand.

Let's take an example where we have a Employee class with equals() method implemented in it. Default implementation can be generated from IDE. Eclipse, IntellJ and NetBeans all three provide it.

```java
class Employee {
	String empId;
	String empDob;

	public Employee(String id, String dob) {
		empId = id;
		empDob = dob;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Employee employee = (Employee) o;
		if (empDob != null ? !empDob.equals(employee.empDob) : employee.empDob != null) return false;
		if (empId != null ? !empId.equals(employee.empId) : employee.empId != null) return false;
		return true;
	}

}

```

Now, we have a main method in our class which calls another method to populate a cache of employees and then lookup one of the employee from the map.

```java
/**
* Main method to start the flow
* @param args
*/
public static void main(String[] args) {
	Map<Employee, String> cache = loadEmployeeCache();
	Employee lookUpKey = new Employee("101", "10111992");
	String empName = cache.get(lookUpKey);
	System.out.println(empName);
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
```

We will get output as null because we have overridden the implementation of equals() method but not hashCode(). Let's add hashCode() method to Employee class and check the output again.

```java
@Override
public int hashCode() {
	int result = empId != null ? empId.hashCode() : 0;
	result = 31 * result + (empDob != null ? empDob.hashCode() : 0);
	return result;
}
```

Output will be Bob now since we have hashCode implementation as well. Let's try one more example. Remove the hashCode() implementation again and implement a set in main method.

```java
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
```

Implement a toString() method in Employee class so that we can print the items.

```java
@Override
public String toString() {
	return "Employee [empId=" + empId + ", empDob=" + empDob + "]";
}
```

Since set cannot contain duplicate elements, when we execute this code our out put will have duplicate elements because we are missing hashCode() implementation. Add the hashCode() implementation back and check the output.
This time it will be unique elements printed.

Complete implementation of this program is [here](../Hashing/HashCodeAndEquals.java)

#### Important things to remember
```
- Always use same attributes of an object to generate hashCode() and equals() both.
- Whenever a.equals(b), then a.hashCode() must be same as b.hashCode().
- If you override one, then you should override the other.
- In case of ORM ensure you use getters and not field references.
```
	
Here is a nice article about it, 
[HashCode and Equals](http://www.javaranch.com/journal/2002/10/equalhash.html)	
