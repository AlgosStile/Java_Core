package dz_3;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[6];
        employees[0] = new Employee("John Doe", "Developer", "1234567890", 5000, 30);
        employees[1] = new Employee("Jane Smith", "Manager", "9876543210", 6000, 50);
        employees[2] = new Employee("David Johnson", "Designer", "5555555555", 4000, 40);
        employees[3] = new Employee("Emily Davis", "Developer", "9999999999", 5500, 35);
        employees[4] = new Employee("Michael Brown", "Tester", "7777777777", 4500, 55);
        employees[5] = new Manager("Robert Wilson", "Senior Manager", "1111111111", 8000, 45);

        System.out.println("--- Before Salary Increase ---");
        for (Employee employee : employees) {
            employee.printInfo();
        }

        // Повышение зарплаты сотрудникам старше 45 лет на 5000
        Employee.increaseSalary(employees, 45, 5000);

        System.out.println("--- After Salary Increase ---");
        for (Employee employee : employees) {
            employee.printInfo();
        }

        // Вычисление и вывод среднего возраста и средней зарплаты сотрудников
        double averageAge = Employee.calculateAverageAge(employees);
        double averageSalary = Employee.calculateAverageSalary(employees);
        System.out.println("Average Age: " + averageAge);
        System.out.println("Average Salary: " + averageSalary);
    }
}