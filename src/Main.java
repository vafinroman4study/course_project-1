public class Main {
    public static void main(String[] args) {
        EmployeeBook employees = new EmployeeBook();
        employees.addNewEmployee("Ivan", "Ivanov", "Ivanovich", 1, 1000.0);
        employees.addNewEmployee("Petr", "Petrov", "Petrovich", 2, 800.0);
        employees.addNewEmployee("Alena", "Aleshina", "Aleekseevna", 2, 600.0);
        employees.addNewEmployee("Boris", "Borisov", "Borisovich", 3, 200.0);
        employees.addNewEmployee("Artem", "Artemiev", "Aleksandrovich", 3, 200.0);

        System.out.println("employees.getSize() = " + employees.getSize());
        employees.printAll();
        System.out.println(employees.sumSalary());
        System.out.println(employees.getSize());
        System.out.println("employees.avgSalary() = " + employees.avgSalary());

        employees.printNames();
        System.out.println("employees.minSalaryOverDepartment(2) is " + employees.minSalaryOverDepartment(2));
        employees.removeEmployee(3);
        System.out.println("employees.getSize() = " + employees.getSize());
        employees.printAll();
        System.out.println(employees.sumSalary());
        System.out.println(employees.getSize());
        System.out.println("employees.avgSalary() = " + employees.avgSalary());

        employees.printAll();
        employees.addNewEmployee("Adam", "Adamson", "Sr.", 1, 2000.0);
        System.out.println("employees.getSize() = " + employees.getSize());
        employees.printAll();

        employees.printNamesByDepartment();
    }

}
