package org.example;

public class Employee {
    private String name;
    private Department department;
    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;
        this.department.addEmployee(this);
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(Department department) {
        if(this.department!=null){
            this.department.removeEmployee(this);
        }
        this.department=department;
        if(department!=null)this.department.addEmployee(this);

    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }


    public String toString()
    {
        if(department!=null && this!= department.getBoss()){
            return name+" works in "+department;
        }
        else if(department!=null)
        {
            return name + " is the boss of "+department.getName()+" department";
        }
        else return name + " with no department.";
    }
}
