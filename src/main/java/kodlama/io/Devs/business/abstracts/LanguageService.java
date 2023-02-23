package kodlama.io.Devs.business.abstracts;

import java.util.List;



import kodlama.io.Devs.core.utilities.results.DataResult;
import kodlama.io.Devs.core.utilities.results.Result;
import kodlama.io.Devs.entities.Language;

public interface LanguageService {

	DataResult<List<Language>> getAll();
	DataResult<Language> getById(int id);
	Result Add(Language language);
	Result Update(Language language);
	Result Delete(int langId);
	DataResult<List<Language>> getAllByPage(int pageNo, int pageSize, String sortBy);
}
