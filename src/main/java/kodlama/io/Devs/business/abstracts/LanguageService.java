package kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Devs.entities.Language;

public interface LanguageService {

	List<Language> getAll();
	Language getById(int id);
	void Add(Language language) throws Exception;
	void Update(Language language);
	void Delete(Language language);
}
