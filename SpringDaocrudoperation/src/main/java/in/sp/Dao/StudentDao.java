package in.sp.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import in.sp.demo.Student;
import in.sp.demo.Studentrowmapper;

@Repository
public class StudentDao {
	@Autowired
	private JdbcTemplate jd;

	public void setJd(JdbcTemplate jd) {
		this.jd = jd;

	}

	public Student save(Student st) {

		String query = "insert into stud(name,email,contact) values(?,?,?)";
		jd.update(query, st.getName(), st.getEmail(), st.getContact());
         return st;

	}

	public List<Student> getallstudent() {
		String query = "select * from stud";
		List<Student> list = jd.query(query, new Studentrowmapper());
		return list;
	}

	public void Delete(int id) {
		String query = "delete from stud where id=?";
		jd.update(query, id);

	}

	public void update(Student s) {
		String query = "update stud set name=?, email=?,contact=? where id=?";
		jd.update(query, s.getName(), s.getEmail(), s.getContact(), s.getId());

	}

}
