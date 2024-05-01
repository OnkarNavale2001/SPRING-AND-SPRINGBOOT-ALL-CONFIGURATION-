package in.sp.main;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.sp.entity.Employee;
import in.sp.resources.SpringConfigFile;
import in.sp.service.StudentService;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigFile.class);
		StudentService service = context.getBean(StudentService.class);

		Scanner scanner = new Scanner(System.in);
		int choice;
		boolean b = true;
		while (true) {
			System.out.println("Choose an operation:");
			System.out.println("1. Insert data");
			System.out.println("2.View  data");
			System.out.println("3 Delete data");
			System.out.println("4 Update  data");
			System.out.println("5 to exit");

			choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {
			case 1:
				System.out.println("Enter details:");
				System.out.println("Name: ");
				String name = scanner.nextLine();
				System.out.println("Email: ");
				String email = scanner.nextLine();
				System.out.println("Age: ");
				String Age = scanner.nextLine();

				Employee st1=context.getBean(Employee.class);
				st1.setName(name);
				st1.setEmail(email);
				st1.setAge(Age);
				service.savedata(st1);

				System.out.println("Data added  successfully!");
				break;
			case 2:
				List<Employee> list = service.getall();
				
				for (Employee s : list) {
					System.out.println(s.getId() + " " + s.getAge() + " " + s.getEmail() + " " + s.getName());

				}
				break;
			case 3:
				System.out.println("enter the id");
				int id = scanner.nextInt();
				Employee st3 = context.getBean(Employee.class);
				st3.setId(id);
				service.delete(st3);
				System.out.println("delete successfully");
				break;
			case 4:
				System.out.println("Enter the id to update");
				int id1 = scanner.nextInt();
				System.out.print("Name: ");
				String name1 = scanner.nextLine();
				System.out.print("Email: ");
				String email1 = scanner.nextLine();
				System.out.print("Age: ");
				String Age1 = scanner.nextLine();
			Employee s = context.getBean(Employee.class);
				s.setAge(Age1);
				s.setEmail(email1);
				s.setId(id1);
				s.setName(name1);
				service.update(s);
				System.out.println("Update data successfully");
				break;
			default:
				System.exit(0);
			}
		}

	}
}
