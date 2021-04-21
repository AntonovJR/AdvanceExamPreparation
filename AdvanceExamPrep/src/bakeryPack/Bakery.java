package bakeryPack;

import java.util.ArrayList;
import java.util.List;

public class Bakery {
    public String name;
    public int capacity;
    public List<Employee> employees;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void add(Employee employee) {
        if (this.capacity > employees.size()) {
            employees.add(employee);
        }
    }

    public boolean remove(String name) {
        return employees.removeIf(obj -> obj.getName().equals(name));

    }

    public Employee getOldestEmployee() {
        int max = 0;
        Employee oldestEmployee = null;

        for (Employee employee : employees) {
            if (employee.getAge() > max) {
                max = employee.getAge();
                oldestEmployee = employee;
            }

        }

        return oldestEmployee;
    }

    public Employee getEmployee(String name) {
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                return employee;
            }

        }

        return null;
    }

    public int getCount() {
        return employees.size();
    }
    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Employees working at Bakery %s:%n", this.name));
        for (Employee employee : employees) {
            sb.append(employee);
            sb.append(System.lineSeparator());

        }

        return sb.toString();
    }

}