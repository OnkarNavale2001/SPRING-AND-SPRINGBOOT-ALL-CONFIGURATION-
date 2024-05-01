package in.sp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sp.Dao.StudentDao;
import in.sp.demo.Student;
@Service
public class StudentService {
	@Autowired
	private StudentDao Dao;
  public Student save(Student st)
  {
	  return Dao.save(st);
	  
  }
  public List<Student> getalluser()
  {
	  return Dao.getallstudent();
  }
  public void delete(int id)
  {
	  Dao.Delete(id);
  }
  public void update (Student s)
  { 
	   Dao.update(s);  
  }
}
