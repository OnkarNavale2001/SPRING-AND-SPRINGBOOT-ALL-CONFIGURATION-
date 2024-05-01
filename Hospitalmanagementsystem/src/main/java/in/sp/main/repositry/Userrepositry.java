package in.sp.main.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.sp.main.beans.user;
@Repository
public interface Userrepositry extends JpaRepository<user, Integer> {
     
	  @Query("SELECT u FROM user u WHERE u.email = :email AND u.password = :password")
	    user findByEmailAndPassword(@Param("email") String email, @Param("password") String password);	
}
