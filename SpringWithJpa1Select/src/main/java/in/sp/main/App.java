package in.sp.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.sp.dao.StudentDao;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("/in/sp/resources/applicationContext.xml");
        
        StudentDao stdDao = (StudentDao) context.getBean("stdDaoImpl");
        stdDao.searchStudent(2);
    }
}
