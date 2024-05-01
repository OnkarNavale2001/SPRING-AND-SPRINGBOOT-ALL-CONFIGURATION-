package in.sp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sp.entity.Student;
import in.sp.repository.StudentRepository;

@Service
public class StudentService
{
	@Autowired
	private StudentRepository studentRepository;
	
	public void insertStdDetailsService(Student std)
	{
		try
		{
			studentRepository.save(std);
			System.out.println("Insertion success");
		}
		catch(Exception e)
		{
			System.out.println("Insertion failed");
			e.printStackTrace();
		}
	}
	
	public void updateStdDetailsService(int id, float marks)
	{
		try
		{
			Optional<Student> optional = studentRepository.findById(id);
			Student std = optional.get();
			std.setMarks(marks);
			
			studentRepository.save(std);
			System.out.println("Updation success");
		}
		catch(Exception e)
		{
			System.out.println("Updation failed");
			e.printStackTrace();
		}
	}
	
	public void deleteStdDetailsService(int id)
	{
		try
		{
			studentRepository.deleteById(id);
			System.out.println("Deletion success");
		}
		catch(Exception e)
		{
			System.out.println("Deletion failed");
			e.printStackTrace();
		}
	}
	
	public Student getStdDetailsService(int id)
	{
		Optional<Student> optional = studentRepository.findById(id);
		Student std = optional.get();
		return std;
	}
	
	public List<Student> getAllStdDetailsService()
	{
		return studentRepository.findAll();
	}
}