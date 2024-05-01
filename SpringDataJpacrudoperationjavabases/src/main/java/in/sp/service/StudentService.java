package in.sp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import antlr.collections.List;
import in.sp.entity.Employee;
import in.sp.repository.StudentRepository;


@Service
public class StudentService
{
	@Autowired
	private StudentRepository repo;
	public void savedata(Employee e)
	{
		repo.save(e);
	}
	public java.util.List<Employee> getall()
	{
		return repo.findAll();
	}
	public void delete(Employee e)
	{
		repo.delete(e);
	}
	public void update(Employee e)
	{
		repo.save(e);
	}
}