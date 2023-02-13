public class EmployeeBook {
    private int size = 0;
    private Employee[] stuffList;
    final private int maxDepartmentNum = 5;

    public EmployeeBook() {
        this.stuffList = new Employee[10];
    }

    public int getSize() {
        return size;
    }
    public void addNewEmployee(String firstName, String lastName, String middleName, int department, double salary) {
        if (size >= stuffList.length) {
            System.out.println("Нельзя добавить запись о сотруднике, закончилось место");
        } else {
            Employee newEmployee = new Employee(firstName, lastName, middleName, department, salary);
            size++;
            for (int i = 0; i < size; i++) {
                if (stuffList[i] == null) {
                    stuffList[i] = newEmployee;
                }
            }
        }
    }

    public Employee getEmployeeById(int id) {
        for (Employee current : stuffList) {
            if (current.getId() == id) {
                return current;
            }
        }
        System.out.println("Нет такого сотрудника");
        return null;
    }
    public void removeEmployee(int id) {
        for (int i = 0; i < stuffList.length; i++) {
            final Employee current = stuffList[i];
            if (current.getId() == id) {
                System.out.println("Запись о сотруднике " + current + " удалена");
                //System.arraycopy(stuffList, i + 1, stuffList, i, size - i - 1);
                stuffList[i] = null;
                size--;
                return;
            }
        }
    }
    public void printAll() {
        System.out.println("Вся информация по сотрудникам:");
        for (final Employee current : stuffList) {
            if (current != null) {
                System.out.println(current);
            }
        }
    }
    public double sumSalary() {
        double res = 0.0;
        for (int i = 0; i < stuffList.length; i++) {
            if (stuffList[i]!=null) {
                res += stuffList[i].getSalary();
            }
        }
        return res;
    }
    public double sumSalaryOverDepartment(int dpt) {
        double res = 0.0;
        for (int i = 0;
             (i < stuffList.length)
                 && (stuffList[i]!=null)
                 && (stuffList[i].getDepartment()==dpt);
             i++) {
            res += stuffList[i].getSalary();
        }
        return res;
    }

    public Employee minSalary() {
        double minValue = 1.7E+308;
        Employee res = stuffList[0];
        for (Employee current : stuffList) {
            if (current != null) {
                if  (current.getSalary() < minValue) {
                    minValue = current.getSalary();
                    res = current;
                }
            }
        }
        System.out.println("Сотрудник с минимальной зарплатой: " + res);
        return res;
    }
    public Employee minSalaryOverDepartment(int dpt) {
        double minValue = 1.7E+308;
        Employee res = null;
        for (Employee current : stuffList) {
            if (current != null && current.getDepartment() == dpt)  {
                if  (current.getSalary() < minValue) {
                    minValue = current.getSalary();
                    res = current;
                }
            }
        }
        return res;
    }

    public Employee maxSalary() {
        double minValue = 0;
        Employee res = stuffList[0];
        for (Employee current : stuffList) {
            if (current != null) {
                if(current.getSalary() > minValue) {
                    minValue = current.getSalary();
                    res = current;
                }
            }
        }
        System.out.println("Сотрудник с максимальной зарплатой: " + res);
        return res;
    }
    public Employee maxSalaryOverDepartment(int dpt) {
        double minValue = 0;
        Employee res = null;
        for (Employee current : stuffList) {
            if (current != null && current.getDepartment()==dpt) {
                if(current.getSalary() > minValue) {
                    minValue = current.getSalary();
                    res = current;
                }
            }
        }
        return res;
    }

    public double avgSalary() {
        return sumSalary() / size;
    }
    public double avgSalaryOverDepartment(int dpt) {
        int dptSize = 0;
        double res = .0;
        for (Employee current : stuffList) {
            if (current != null && current.getDepartment() == dpt) {
                dptSize++;
            }
        }
        if (dptSize>0) {
            res = sumSalaryOverDepartment(dpt) / dptSize;
        }else{
            System.out.println("В этом отделе нет сотрудников");
        }
        return res;
    }

    public void riseSalary(double rate) {
        double newSalary;
        for (Employee current : stuffList) {
            if (current != null) {
                newSalary = current.getSalary() * (1 + rate);
                current.setSalary(newSalary);
            }
        }
    }
    public void riseSalaryOverDepartment(int dpt, double rate) {
        double newSalary;
        for (Employee current : stuffList) {
            if (current != null && current.getDepartment() == dpt) {
                newSalary = current.getSalary() * (1 + rate);
                current.setSalary(newSalary);
            }
        }
    }
    public void printNames() {
        System.out.println("Имена всех сотрудников:");
        for (Employee employee : stuffList) {
            if (employee != null) {
                System.out.println(
                        employee.getFirstName() + " "
                                + employee.getLastName() + " "
                                + employee.getMiddleName()
                );
            }
        }
    }
    public void printNamesOverDepartment(int dpt) {
        System.out.println("Имена всех сотрудников отдела " + dpt + ":");
        for (Employee employee : stuffList) {
            if (employee != null && employee.getDepartment() == dpt) {
                System.out.println(
                    employee.getId()
                    + ": " + employee.getFirstName()
                    + " " + employee.getLastName()
                    + " " + employee.getMiddleName()
                    + String.format(" %.2f", employee.getSalary())
                );
            }
        }
    }
    public void printNamesByDepartment() {
        System.out.println("Имена всех сотрудников:");
        for (int i = 1; i <= maxDepartmentNum; i++) {
            printNamesOverDepartment(i);
        }
    }
    public void printNamesSalaryLess(double compSalary) {
        System.out.println("Имена всех сотрудников с меньшей зарплатой:");
        for (Employee employee : stuffList) {
            if (employee != null && employee.getSalary() < compSalary) {
                System.out.println(
                        employee.getId()
                        + " " + employee.getFirstName()
                        + " " + employee.getLastName()
                        + " " + employee.getMiddleName()
                        + " " + employee.getSalary()
                );
            }
        }
    }
    public void printNamesSalaryMore(double compSalary) {
        System.out.println("Имена всех сотрудников с большей зарплатой:");
        for (Employee employee : stuffList) {
            if (employee != null && employee.getSalary() >= compSalary) {
                System.out.println(
                        employee.getId()
                        + " " + employee.getFirstName()
                        + " " + employee.getLastName()
                        + " " + employee.getMiddleName()
                        + " " + employee.getSalary()
                );
            }
        }
    }

    public void riseSalary(int id, double riseRate) {
        double newSalary;
        for (Employee current : stuffList) {
            if (current != null && current.getId() == id) {
                newSalary = current.getSalary() * (1 + riseRate);
                current.setSalary(newSalary);
            }
        }
    }
    public void riseSalary(int id, int newDpt) {
        for (Employee current : stuffList) {
            if (current != null && current.getId() == id) {
                current.setDepartment(newDpt);
            }
        }
    }



}
