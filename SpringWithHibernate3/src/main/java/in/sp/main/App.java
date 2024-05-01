
package in.sp.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.sp.beans.Student;
import in.sp.dao.StudentDao;
import in.sp.resources.SpringConfigFile;

public class App 
{
    public static void main( String[] args )
    {
    	Student std = new Student();
    	std.setStdid(2);
    	std.setName("rahul");
    	std.setRollno(102);
    	std.setCity("pune");
    	
    	ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigFile.class);
    	
    	StudentDao stdDao = (StudentDao) context.getBean("stdDaoImplBean");

    	stdDao.addStdDetails(std);
    	
//    	stdDao.updateStdDetails(std);
    	
//    	stdDao.searchStdDetails(2);

//    	stdDao.deleteStdDetails(std);
    }
}
