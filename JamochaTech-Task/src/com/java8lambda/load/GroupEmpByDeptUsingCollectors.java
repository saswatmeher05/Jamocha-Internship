package com.java8lambda.load;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Employee{
    int id;
    String name;
    int salary;
    String dept;

    public Employee(int id, String name, int salary, String dept){
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.dept = dept;
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

}

class Department{
    int id;
    String name;

    public Department(int id, String name) {
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

    
}

public class GroupEmpByDeptUsingCollectors {
    public static void main(String[] args) {
        List<Employee> list=new ArrayList<Employee>();
        list.add(new Employee(1,"Somu",15000,"dev"));
        list.add(new Employee(2,"Omm",13000,"qa"));
        list.add(new Employee(3,"Subrat",18000,"qa"));
        list.add(new Employee(4,"Rajesh",25000,"dev"));
        list.add(new Employee(5,"Aman",18000,"qa"));
        list.add(new Employee(6,"Jadeja",25000,"dev"));
        list.add(new Employee(7,"Virat",18000,"qa"));
        list.add(new Employee(8,"Karan",25000,"dev"));
        list.add(new Employee(9,"Rakesh",18000,"qa"));
        list.add(new Employee(10,"Kamles",25000,"dev"));

        System.out.println("Group by Dept:");
        Map<String,List<Employee>> map=list.stream().collect(Collectors.groupingBy(Employee::getDept));
        for(Map.Entry<String,List<Employee>> entry:map.entrySet()) {
        	List<Employee> lt=entry.getValue();
        	lt.forEach(emp->{
        		System.out.print(emp.getId()+"\t");
        		System.out.print(emp.getName()+"\t");
        		System.out.print(emp.getSalary()+"\t");
        		System.out.print(emp.getDept()+"\t\n");
        	});
        }
        
        System.out.println("Sum of Salary by Dept:");
        Map<String,Integer> salMap=list.stream().collect(Collectors.groupingBy(Employee::getDept,Collectors.summingInt(Employee::getSalary)));
        for(Map.Entry<String,Integer> entry:salMap.entrySet()) {
        	System.out.println(entry.getKey()+"\t"+entry.getValue());
        }
        
        Stream.iterate(1,element->element+1).filter(element->element%5==0).limit(10).forEach(System.out::print);
    }
}
