package in.sp.main.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.sp.main.beans.Specialist;

@Repository
public interface Specailistrepositry extends JpaRepository<Specialist, Integer> {

}
