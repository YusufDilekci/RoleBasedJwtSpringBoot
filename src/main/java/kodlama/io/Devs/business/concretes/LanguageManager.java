package kodlama.io.Devs.business.concretes;


import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Devs.core.utilities.results.DataResult;
import kodlama.io.Devs.core.utilities.results.ErrorDataResult;
import kodlama.io.Devs.core.utilities.results.ErrorResult;
import kodlama.io.Devs.core.utilities.results.Result;
import kodlama.io.Devs.core.utilities.results.SuccessDataResult;
import kodlama.io.Devs.core.utilities.results.SuccessResult;
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
	public DataResult<List<Language>> getAll() {

		return new SuccessDataResult<List<Language>>("Data listelendi", languageRepository.findAll());
	}

	@Override
	public DataResult<Language> getById(int id) {
		Language lang = languageRepository.findById(id).get();
		if(lang == null) {
			return new ErrorDataResult<Language>("Asfsaf");
		}
		return new SuccessDataResult<Language>("Language getirldi", lang);
	}

	@Override
	public Result Add(Language language) {
		for(Language lang:languageRepository.findAll()) {
			if(language.getLanguageName() == lang.getLanguageName()) {
				return new ErrorResult("İsimler tekrar edemez.");
			}
		}
		if(language.getLanguageName() == null) {
			return  new ErrorResult("Programlama dili boş geçilemez.");
		}
		
		languageRepository.save(language);
		return new SuccessResult();
		
	}


	@Override
	public Result Update(Language language) {
		
		Language lang = languageRepository.getReferenceById(language.getLanguageId());
		if(lang != null) {
			lang.setLanguageName(language.getLanguageName());
			lang.setPopularity(language.getPopularity());
		}
		
		languageRepository.save(lang);
		return new SuccessResult();

		
	}

	@Override
	public Result Delete(int langId) {
		
		languageRepository.deleteById(langId);
		return new SuccessResult();
	}
	
	public DataResult<List<Language>> getAllByPage(int pageNo, int pageSize, String sortBy){
		
		Pageable pageable = PageRequest.of(pageNo-1, pageSize, Sort.by(sortBy).ascending());
		return new SuccessDataResult<List<Language>>(languageRepository.findAll(pageable).getContent());
	}

}
