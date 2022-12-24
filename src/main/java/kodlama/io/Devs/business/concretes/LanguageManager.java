package kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.Devs.entities.Language;

@Service
public class LanguageManager implements LanguageService {
	private LanguageRepository languageRepository;
	
	@Autowired
	public LanguageManager(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	@Override
	public List<Language> getAll() {

		return languageRepository.getAll();
	}

	@Override
	public Language getById(int id) {

		return languageRepository.getById(id);
	}

	@Override
	public void Add(Language language) throws Exception{
		for(Language lang:languageRepository.getAll()) {
			if(language.getLanguageName() == lang.getLanguageName()) {
				throw new Exception("İsimler tekrar edemez.");
			}
		}
		if(language.getLanguageName() == null) {
			throw new Exception("Programlama dili boş geçilemez.");
		}
		
		languageRepository.Add(language);
		
	}

	@Override
	public void Update(Language language) {
		
		languageRepository.Update(language);
	}

	@Override
	public void Delete(Language language) {
		
		languageRepository.Delete(language);
	
	}

}
