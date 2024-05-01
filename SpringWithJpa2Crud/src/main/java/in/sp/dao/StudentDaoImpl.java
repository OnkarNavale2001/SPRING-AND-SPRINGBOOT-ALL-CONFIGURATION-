package in.sp.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

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

	@Transactional
	@Override
	public void insertStudent(Student std)
	{
		try
		{
			entityManager.persist(std);
			System.out.println("Insertion success");
		}
		catch(Exception e)
		{
			System.out.println("Insertion failed");
			e.printStackTrace();
		}
	}

	@Transactional
	@Override
	public void updateStudent(int id, float marks)
	{
		try
		{
			Student std = entityManager.find(Student.class, id);
			std.setMarks(marks);
			
			System.out.println("Updation success");
		}
		catch(Exception e)
		{
			System.out.println("Updation failed");
			e.printStackTrace();
		}
	}

	@Transactional
	@Override
	public void deleteStudent(int id)
	{
		try
		{
			Student std = entityManager.find(Student.class, id);
			entityManager.remove(std);
			System.out.println("Deletion success");
		}
		catch(Exception e)
		{
			System.out.println("Deletion failed");
			e.printStackTrace();
		}
	}
}
