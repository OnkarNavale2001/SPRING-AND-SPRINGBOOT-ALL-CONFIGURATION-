package in.sp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.sp.entity.Employee;

@Repository
public interface StudentRepository extends JpaRepository<Employee, Integer>
{
	
}