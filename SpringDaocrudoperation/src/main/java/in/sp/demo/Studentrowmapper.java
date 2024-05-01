package in.sp.demo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class Studentrowmapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student st = new Student();
		st.setId(rs.getInt("id"));
		st.setName(rs.getString("name"));
		st.setContact(rs.getString("contact"));
		st.setEmail(rs.getString("email"));

	
		return st;
	}

}
