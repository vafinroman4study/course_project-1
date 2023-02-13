public class Employee {
    private String firstName;
    private String middleName;
    private String lastName;
    private int department;
    private double salary;
    public int id;
    private static int cnt = 0;


    public Employee(String firstName, String lastName, String middleName, int department, double salary) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
        this.id = ++cnt;
    }

    public String getFirstName() {
        return  firstName;
    }

    public String getMiddleName() {
        return  middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public void setDepartment(int newDepartment) {
        department = newDepartment;
    }

    public void setSalary(double newSalary) {
        salary = newSalary;
    }

    @Override
    public String toString() {
        return id + ": full name: "
                + firstName
                + " " + lastName
                + " " + middleName
                + ", dpt: " + department
                + ", salary: " + String.format("%.2f", salary);
    }
}
