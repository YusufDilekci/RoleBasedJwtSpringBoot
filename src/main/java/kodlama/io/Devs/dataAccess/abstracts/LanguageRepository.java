package kodlama.io.Devs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;


import kodlama.io.Devs.entities.Language;

public interface LanguageRepository extends JpaRepository<Language, Integer> {

}
