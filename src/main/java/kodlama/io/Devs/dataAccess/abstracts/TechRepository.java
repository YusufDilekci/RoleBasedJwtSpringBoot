package kodlama.io.Devs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlama.io.Devs.entities.Tech;

public interface TechRepository extends JpaRepository<Tech, Integer> {
	@Query("From Tech where language.languageId=:languageId")
	List<Tech> getByLanguage(int languageId);
}
