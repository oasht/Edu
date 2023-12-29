package org.example.entities;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private Employee boss;
    private List<Employee> employeeList=new ArrayList<>();
    public Department(String name){this.name=name;}

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setBoss(Employee employee) {
        if(employee.getDepartment()!=null){
            employee.getDepartment().removeEmployee(employee);
            this.addEmployee(employee);
        }
        this.boss = employee;
    }

    public Employee getBoss() {
        return boss;
    }

    public List<Employee> getEmployeeList() {
        return new ArrayList<>(employeeList);
    }
public void addEmployee(Employee employee){
    if(employeeList.contains(employee))return;
        employeeList.add(employee);
        if(employee.getDepartment()!=this)
       employee.setDepartment(this);
}
public void removeEmployee(Employee employee){
       if(!employeeList.contains(employee))return;
        if(boss==employee)boss=null;
        employeeList.remove(employee);
        employee.setDepartment(null);
}
    public String toString(){
        if(boss!=null)
            return name+ " department, the boss is "+ boss.getName();
        else return name + " department with no boss";
    }
}
