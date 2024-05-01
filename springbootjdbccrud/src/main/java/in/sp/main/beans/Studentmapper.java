package in.sp.main.beans;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class Studentmapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student s=new Student();
		s.setEmail(rs.getString("email"));
		s.setName(rs.getString("name"));
		s.setId(rs.getInt("id"));
		s.setPassword(rs.getString("password"));
		return s;
	}

}
