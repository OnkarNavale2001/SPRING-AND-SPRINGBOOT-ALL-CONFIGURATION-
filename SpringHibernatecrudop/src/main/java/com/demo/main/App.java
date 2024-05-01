package com.demo.main;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import com.demo.beans.Student;
import com.demo.resources.springconfig;
import com.demo.services.Serviceclas;

public class App {
	public static void main(String[] args) {
   ApplicationContext Context=new AnnotationConfigApplicationContext(springconfig.class);
   
  
  Serviceclas service= Context.getBean(Serviceclas.class);

 
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
              System.out.println("Name: ");
              String name = scanner.nextLine();
              System.out.println("Email: ");
              String email = scanner.nextLine();
              System.out.println("Phone: ");
              int  phone = scanner.nextInt();

              Student st1=Context.getBean(Student.class);
              st1.setName(name);
              st1.setEmail(email);
              st1.setPhone(phone);
              service.insert(st1);
              
              System.out.println("Data added  successfully!");
              break;
          case 2:
                List<Student>  list=service.getall();
                for (Student s : list) {
					System.out.println(s.getId()+" "+s.getPhone()+" "+s.getEmail()+" "+s.getName());
					
				}
              break;
          case 3:
          	 System.out.println("enter the id");
          	 int id=scanner.nextInt();
             Student st3=Context.getBean(Student.class);
             st3.setId(id);
          	 service.delete(st3);
          	 System.out.println("delete successfully");
          	 break;
          case 4:
          	System.out.println("Enter the id to update");
          	 int id1=scanner.nextInt();
          	 System.out.print("Name: ");
               String name1 = scanner.nextLine();
               System.out.print("Email: ");
               String email1 = scanner.nextLine();
               System.out.print("phone: ");
               int  phone1 = scanner.nextInt();
               Student s=new Student();
               s.setPhone(phone1);
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
