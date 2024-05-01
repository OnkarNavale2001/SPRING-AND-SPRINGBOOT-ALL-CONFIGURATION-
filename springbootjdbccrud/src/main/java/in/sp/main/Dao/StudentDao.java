package in.sp.main.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import in.sp.main.beans.Student;
import in.sp.main.beans.Studentmapper;
@Repository
public class StudentDao {
	@Autowired
  JdbcTemplate template;
	
	public int senddata(Student s)
	{
		String query="insert into stud(name,email,password) values(?,?,?)";
		return template.update(query,s.getName(),s.getEmail(),s.getPassword());
	}
  public List<Student> getall()
  {
	  return template.query("select * from stud", new Studentmapper());
  }
  public int delete(Student s)
	{
		String query="delete from stud where id=?";
		return template.update(query,s.getId());
	}
	
    public List<Student> getyid(int id)
    {
    	return template.query("select * from  stud where id=?",new Object[]{id}, new Studentmapper());
    	
    }
    public int updatedata(Student s) {
    	
    	String query="update stud set email=?, name=? ,password=? where id=?";
    	return template.update(query,s.getEmail(),s.getName(),s.getPassword(),s.getId());
    }
    
  
  
  
}
