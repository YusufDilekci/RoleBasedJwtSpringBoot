package kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Devs.entities.Language;

@RestController //annotation
@RequestMapping("/api/languages")
public class LanguagesController {
	private LanguageService languageService;
	
	@Autowired //Controller parametresini 
	public LanguagesController(LanguageService languageService) {
		super();
		this.languageService = languageService;
	}


	@GetMapping("/getall")
	public List<Language> getAll(){
		
		return languageService.getAll();
	}

	@GetMapping("/getbyid")
	public Language getById(int id){
		
		return languageService.getById(id);
	}
	
	@GetMapping("/add")
	public String add(){
		
		 return "Add";
	}

	@PostMapping("/add")
	public void add(Language lang) throws Exception{
		
		 languageService.Add(lang);
	}
	

	@GetMapping("/delete")
	public void delete(Language lang){
		
		 languageService.Delete(lang);
	}
	
	
	@GetMapping("/update")
	public String update(){
		
		return "<li>Updated</li>";
		
	}

	@PostMapping("/update")
	public void update(Language lang){
		
		 languageService.Update(lang);
	}
	
	
	
}
