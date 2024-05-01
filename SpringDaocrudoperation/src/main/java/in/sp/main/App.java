package in.sp.main;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.sp.demo.Student;
import in.sp.resources.Springconfig;
import in.sp.services.StudentService;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Springconfig.class);
        StudentService st = context.getBean(StudentService.class);
        Scanner scanner = new Scanner(System.in);
        int choice;
        boolean b=true;
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
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Contact: ");
                    String contact = scanner.nextLine();

                    Student st1 = new Student();
                    st1.setName(name);
                    st1.setEmail(email);
                    st1.setContact(contact);

                    st.save(st1);
                    System.out.println("Data added  successfully!");
                    break;
                case 2:
                      List<Student>  list= st.getalluser();
                      for (Student s : list) {
						System.out.println(s.getId()+" "+s.getContact()+" "+s.getEmail()+" "+s.getName());
						
					}
                    break;
                case 3:
                	 System.out.println("enter the id");
                	 int id=scanner.nextInt();
                	 st.delete(id);
                	 System.out.println("delete successfully");
                	 break;
                case 4:
                	System.out.println("Enter the id to update");
                	 System.out.println("enter the id");
                	 int id1=scanner.nextInt();
                	 System.out.print("Name: ");
                     String name1 = scanner.nextLine();
                     System.out.print("Email: ");
                     String email1 = scanner.nextLine();
                     System.out.print("Contact: ");
                     String contact1 = scanner.nextLine();
                     Student s=new Student();
                     s.setContact(contact1);
                     s.setEmail(email1);
                     s.setId(id1);
                     s.setName(name1);
                     st.update(s);
                     System.out.println("Update data successfully");
                
                default:
                	b=false;
                    System.out.println("Invalid");
            }
        }
    }
}
