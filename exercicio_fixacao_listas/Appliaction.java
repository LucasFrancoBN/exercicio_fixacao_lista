package exercicio_fixacao_listas;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import enttites.Employee;

public class Appliaction {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Employee> employees = new ArrayList<>();
		System.out.print("How many employees will be registered? ");
		int quantityEmployees = sc.nextInt();

		for (int i = 0; i < quantityEmployees; i++) {
			System.out.printf("Employee #%d%n", i + 1);
			System.out.print("Id: ");
			int id = sc.nextInt();
			while (hasId(employees, id)) {
				System.out.print("Id already taken. Try again: ");
				id = sc.nextInt();
			}

			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();

			System.out.print("Salary: ");
			Double salary = sc.nextDouble();

			Employee employee = new Employee(id, name, salary);

			employees.add(employee);

		}

		System.out.print("Enter the employee id that will have salary increase: ");
		int idEmployee = sc.nextInt();
		Employee employeeIncreaseSalary = employees.stream().filter(e -> e.getId() == idEmployee).findFirst()
				.orElse(null);

		if (employeeIncreaseSalary == null) {
			System.out.println("This id does not exist!");
		} else {
			System.out.print("Enter the percentage: ");
			double percentage = sc.nextDouble();
			employeeIncreaseSalary.increaseSalary(percentage);
		}

		System.out.println("List of employees:");
		for (Employee e : employees) {
			System.out.println(e.toString());
		}

		sc.close();
	}

	public static boolean hasId(List<Employee> list, int id) {
		Employee employeeExisting = list.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
		return employeeExisting != null;
	}

}
