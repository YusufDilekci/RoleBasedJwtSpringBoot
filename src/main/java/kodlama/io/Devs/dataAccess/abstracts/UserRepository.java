package kodlama.io.Devs.dataAccess.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlama.io.Devs.core.entities.User;



public interface UserRepository extends JpaRepository<User, Integer>{

	Optional<User> findByEmail(String email);
	
	@Modifying
	@Query(
			  value = "UPDATE users SET deleted = true where id = :userId", 
			  nativeQuery = true)
	void deleteById(@Param("userId") int userId);
} 
