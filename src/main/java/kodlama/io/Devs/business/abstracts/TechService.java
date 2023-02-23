package kodlama.io.Devs.business.abstracts;

import java.util.List;



import kodlama.io.Devs.core.utilities.results.DataResult;
import kodlama.io.Devs.core.utilities.results.Result;
import kodlama.io.Devs.entities.Tech;

public interface TechService {
	DataResult<List<Tech>> getAll();
	DataResult<List<Tech>> getByLanguage(int languageId);
	DataResult<Tech> getById(int id);
	Result Add(Tech tech);
	Result Update(Tech tech);
	Result Delete(Tech tech);
}
