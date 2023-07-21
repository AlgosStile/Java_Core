package dz_3;

class Manager extends Employee {
    public Manager(String fullName, String position, String phoneNumber, double salary, int age) {
        super(fullName, position, phoneNumber, salary, age);
    }

    public static void increaseSalary(Employee[] employees, int minAge, double raiseAmount) {
        for (Employee employee : employees) {
            if (!(employee instanceof Manager) && employee.getAge() > minAge) {
                employee.setSalary(employee.getSalary() + raiseAmount);
            }
        }
    }
}