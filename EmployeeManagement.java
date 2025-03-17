//main class
public class EmployeeManagement {
    public static void main(String[] args) {
        Employee emp1 = new FullTimeEmployee(101, "Alice", 50000, "HR");
        Employee emp2 = new PartTimeEmployee(102, "Bob", 200, 120, "IT");

        emp1.displayDetails();
        emp2.displayDetails();
    }
}
//abstract class
abstract class Employee implements Department {
    int employeeId;
    String name;
    double baseSalary;
    private String department;
    Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }
//abstract method
    abstract double calculateSalary();
    //concrete method
    public void displayDetails() {
        System.out.println("ID: " + employeeId + " Name: " + name + " Department: " + getDepartmentDetails() + " Salary: " + calculateSalary());
    }

    public void assignDepartment(String department) {
        this.department = department;
    }

    public String getDepartmentDetails() {
        return department;
    }
    double getBaseSalary() {
        return baseSalary;
    }
}
//interface
interface Department{
    void assignDepartment(String department);
    String getDepartmentDetails();

}
//subclass
class FullTimeEmployee extends Employee {
    FullTimeEmployee(int employeeId, String name, double baseSalary, String department) {
        super(employeeId, name, baseSalary);
        assignDepartment(department);
    }
    @Override
    double calculateSalary() {
        return getBaseSalary();
    }
}
//subclass
class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    PartTimeEmployee(int employeeId, String name, double hourlyRate, int hoursWorked, String department) {
        super(employeeId, name,0);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
        assignDepartment(department);
    }

    @Override
    double calculateSalary() {
        return hourlyRate * hoursWorked;
    }
}
/*ID: 101 Name: Alice Department: HR Salary: 50000.0
ID: 102 Name: Bob Department: IT Salary: 24000.0
 */