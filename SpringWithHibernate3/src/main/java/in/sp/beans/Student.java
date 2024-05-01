package in.sp.beans;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Student
{
	@Id
	private int stdid;
	private String name;
	private int rollno;
	private String city;
	
	public int getStdid() {
		return stdid;
	}
	public void setStdid(int stdid) {
		this.stdid = stdid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
}
