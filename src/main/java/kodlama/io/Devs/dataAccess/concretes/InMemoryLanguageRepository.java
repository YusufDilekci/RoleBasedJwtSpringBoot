package kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.Devs.entities.Language;

@Repository
public class InMemoryLanguageRepository implements LanguageRepository {
	
	List<Language> languages;
	
	
	public InMemoryLanguageRepository() {
		this.languages = new ArrayList<Language>();
		this.languages.add(new Language(1, "C#", 5, "Microsoft"));
		this.languages.add(new Language(2, "Python", 1, "Guido van Rossum"));
		this.languages.add(new Language(3, "Java", 3, "James Arthur Gosling"));
		this.languages.add(new Language(4, "Javascript", 2, "Brendan Eich"));
	}

	@Override
	public List<Language> getAll() {
		// TODO Auto-generated method stub
		return languages;
	}

	@Override
	public Language getById(int id) {
		// TODO Auto-generated method stub
		Language desiredLang = null;
		
		for(Language lang: languages) {
			if(lang.getLanguageId() == id) {
				desiredLang = lang;
			}
		}
		return desiredLang;
	}


	@Override
	public void Add(Language entity) {
		// TODO Auto-generated method stub
		languages.add(entity);
	}

	@Override
	public void Update(Language entity) {
		// TODO Auto-generated method stub
		
		languages.set(entity.getLanguageId()-1, entity);
	}

	@Override
	public void Delete(Language entity) {
		// TODO Auto-generated method stub
		languages.remove(entity.getLanguageId());
	}

}
