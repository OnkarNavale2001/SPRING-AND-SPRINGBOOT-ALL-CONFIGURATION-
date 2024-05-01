package in.sp.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.sp.entity.Student;
import in.sp.resources.SpringConfigFile;
import in.sp.service.StudentService;

public class App 
{
    public static void main( String[] args )
    {
    	Student std = new Student();
    	std.setId(3);
    	std.setName("ccc");
    	std.setRollno(103);
    	std.setMarks(89.13f);
    	
    	
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigFile.class);
        
        StudentService stdService = (StudentService) context.getBean("studentService");
        boolean status = stdService.insertStdDetailsService(std);
        if(status)
        {
        	System.out.println("Insertion success");
        }
        else
        {
        	System.out.println("Insertion failed");
        }
    }
}
