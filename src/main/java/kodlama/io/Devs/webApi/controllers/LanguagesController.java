package kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Devs.core.utilities.results.DataResult;
import kodlama.io.Devs.core.utilities.results.Result;
import kodlama.io.Devs.entities.Language;

@RestController //annotation
@RequestMapping("/api/languages")
public class LanguagesController {
	private LanguageService languageService;
	
	@Autowired //dependencyleri enjekte edilmesini sağlar
	public LanguagesController(LanguageService languageService) {
		super();
		this.languageService = languageService;
	}


	@GetMapping("/getall")
	//@RolesAllowed("ADMIN")
	public DataResult<List<Language>> getAll(){
		
		return languageService.getAll();
	}
	
	@GetMapping("/getbyid")
	public DataResult<Language> getById(@RequestParam int id){
		
		return languageService.getById(id);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Language lang){
		
		 return languageService.Add(lang);
	}
	

	@GetMapping("/delete")
	public Result delete(@RequestParam int langId){
		
		 return languageService.Delete(langId);
	}
	
	

	@PostMapping("/update")
	public Result update(@RequestBody Language lang){
		
		 return languageService.Update(lang);
	}
	
	@GetMapping("/getAllByPage")
	public DataResult<List<Language>> getAllByPage(@RequestParam int pageNo, int pageSize, String sortBy){
		
		return languageService.getAllByPage(pageNo, pageSize, sortBy);
	}
	
}
