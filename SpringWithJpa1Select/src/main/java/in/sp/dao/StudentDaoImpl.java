package in.sp.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import in.sp.entity.Student;

public class StudentDaoImpl implements StudentDao
{
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void searchStudent(int id) 
	{
		try
		{
			Student std = entityManager.find(Student.class, id);
			System.out.println("--------------------------------------");
			System.out.println("Name : "+std.getName());
			System.out.println("Rollno : "+std.getRollno());
			System.out.println("Marks : "+std.getMarks());
			System.out.println("--------------------------------------");
		}
		catch(Exception e)
		{
			System.out.println("Student details not found");
			e.printStackTrace();
		}
	}
}
