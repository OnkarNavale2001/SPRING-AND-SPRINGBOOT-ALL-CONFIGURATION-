package in.sp.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.sp.dao.StudentDao;
import in.sp.entity.Student;
import in.sp.resources.SpringConfigFile;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigFile.class);
        
        StudentDao stdDao = (StudentDao) context.getBean("stdDaoImpl");
        
//        stdDao.searchStudent(2);
        
        
//        Student std = new Student();
//        std.setId(4);
//        std.setName("ddd");
//        std.setRollno(104);
//        std.setMarks(82.74f);
//        stdDao.insertStudent(std);
        
        
        stdDao.updateStudent(4, 75.66f);
        
        
//        stdDao.deleteStudent(4);
    }
}
