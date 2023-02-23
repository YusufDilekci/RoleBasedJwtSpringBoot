package kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstracts.TechService;
import kodlama.io.Devs.core.utilities.results.DataResult;
import kodlama.io.Devs.core.utilities.results.Result;
import kodlama.io.Devs.core.utilities.results.SuccessDataResult;
import kodlama.io.Devs.core.utilities.results.SuccessResult;
import kodlama.io.Devs.dataAccess.abstracts.TechRepository;
import kodlama.io.Devs.entities.Tech;

@Service
public class TechManager implements TechService {
	
	private TechRepository techRepository;
	
	@Autowired
	public TechManager(TechRepository techRepository) {
		this.techRepository = techRepository;
	}
	@Override
	public DataResult<List<Tech>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Tech>>(techRepository.findAll());
	}

	@Override
	public DataResult<List<Tech>> getByLanguage(int languageId) {
		// TODO Auto-generated method stub
		
		return new SuccessDataResult<List<Tech>>(techRepository.getByLanguage(languageId));
		
	}

	@Override
	public DataResult<Tech> getById(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<Tech>(techRepository.findById(id).get());
	}

	@Override
	public Result Add(Tech tech){
		// TODO Auto-generated method stub
		techRepository.save(tech);
		
		return new SuccessResult();
	}

	@Override
	public Result Update(Tech tech) {
		// TODO Auto-generated method stub
		Tech techChosen = techRepository.findById(tech.getTechId()).get();
		
		techChosen.setTechName(tech.getTechName());
		techChosen.setLanguage(tech.getLanguage());
		techRepository.save(techChosen);
			
		return new SuccessResult("Güncellendi");

	}

	@Override
	public Result Delete(Tech tech) {
		// TODO Auto-generated method stub
	
		techRepository.delete(tech);
		return new SuccessResult();
		
	}

}
