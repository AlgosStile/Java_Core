package dz_3;

class Employee {
    private String fullName;
    private String position;
    private String phoneNumber;
    private double salary;
    private int age;

    public Employee(String fullName, String position, String phoneNumber, double salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public void printInfo() {
        System.out.println("Full Name: " + fullName);
        System.out.println("Position: " + position);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Salary: " + salary);
        System.out.println("Age: " + age);
        System.out.println();
    }

    public static void increaseSalary(Employee[] employees, int minAge, double raiseAmount) {
        for (Employee employee : employees) {
            if (employee.getAge() > minAge) {
                employee.setSalary(employee.getSalary() + raiseAmount);
            }
        }
    }

    public static double calculateAverageAge(Employee[] employees) {
        int totalAge = 0;
        for (Employee employee : employees) {
            totalAge += employee.getAge();
        }
        return (double) totalAge / employees.length;
    }

    public static double calculateAverageSalary(Employee[] employees) {
        double totalSalary = 0;
        for (Employee employee : employees) {
            totalSalary += employee.getSalary();
        }
        return totalSalary / employees.length;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPosition() {
        return position;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public double getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

