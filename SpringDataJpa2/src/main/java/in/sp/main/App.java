package in.sp.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.sp.entity.Student;
import in.sp.resources.SpringConfigFile;
import in.sp.service.StudentService;

public class App 
{
    public static void main( String[] args )
    {
//    	Student std = new Student();
//    	std.setId(4);
//    	std.setName("ddd");
//    	std.setRollno(104);
//    	std.setMarks(86.23f);
    	
    	
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigFile.class);
        
        StudentService stdService = (StudentService) context.getBean("studentService");
        
        
        //stdService.insertStdDetailsService(std);
        
        //stdService.updateStdDetailsService(4, 96.34f);
        
        //stdService.deleteStdDetailsService(4);
        
        
//        Student std = stdService.getStdDetailsService(1);
//        System.out.println("Name : "+std.getName());
//        System.out.println("Rollno : "+std.getRollno());
//        System.out.println("Marks : "+std.getMarks());
        
        
        List<Student> std_list = stdService.getAllStdDetailsService();
        for(Student std : std_list)
        {
        	System.out.println("--------------------------------");
			System.out.println("Name : "+std.getName());
			System.out.println("Rollno : "+std.getRollno());
			System.out.println("Marks : "+std.getMarks());
        }
    }
}
