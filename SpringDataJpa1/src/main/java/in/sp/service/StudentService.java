package in.sp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sp.entity.Student;
import in.sp.repository.StudentRepository;

@Service
public class StudentService
{
	@Autowired
	private StudentRepository studentRepository;
	
	public boolean insertStdDetailsService(Student std)
	{
		boolean status = false;
		try
		{
			studentRepository.save(std);
			status = true;
		}
		catch(Exception e)
		{
			status = false;
			e.printStackTrace();
		}
		return status;
	}
}