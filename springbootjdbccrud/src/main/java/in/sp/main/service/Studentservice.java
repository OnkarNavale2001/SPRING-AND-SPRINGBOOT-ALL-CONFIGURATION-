package in.sp.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sp.main.Dao.StudentDao;
import in.sp.main.beans.Student;

@Service
public class Studentservice {
	@Autowired
	StudentDao dao;

	public int senddata(Student s) {
		return dao.senddata(s);
	}

	public List<Student> getall() {
		return dao.getall();
	}

	public int delete(Student s) {
		return dao.delete(s);
	}

	public List<Student> getyid(int id) {
		return dao.getyid(id);

	}
	
	public int update(Student s)
	{
		return dao.updatedata(s);
	}
	
	
}
