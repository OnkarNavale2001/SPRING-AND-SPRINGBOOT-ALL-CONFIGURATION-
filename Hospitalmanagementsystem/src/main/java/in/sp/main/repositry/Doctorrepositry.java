package in.sp.main.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.sp.main.beans.doctor;


@Repository
public interface Doctorrepositry extends JpaRepository<doctor, Integer> {
	@Query("SELECT u FROM doctor u WHERE u.email = :email AND u.password = :password")
    doctor findByEmailAndPassword(@Param("email") String email, @Param("password") String password);
	
	
      
}
