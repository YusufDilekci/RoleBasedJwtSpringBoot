package kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Devs.business.abstracts.TechService;
import kodlama.io.Devs.core.utilities.results.DataResult;
import kodlama.io.Devs.core.utilities.results.Result;
import kodlama.io.Devs.entities.Tech;

@RestController //annotation
@RequestMapping("/api/techs")
public class TechsController {
	private TechService techService;
	
	@Autowired
	public TechsController(TechService techService) {
		this.techService = techService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Tech>> getAll(){
		
		return techService.getAll();
	
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Tech tech) {
		return techService.Add(tech);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody Tech tech) {
		return techService.Update(tech);
	}
	
	@GetMapping("/delete")
	public Result delete(@RequestParam Tech tech) {
		return techService.Update(tech);
	}
	
	@GetMapping("/getbyid")
	public DataResult<Tech> getById(@RequestParam int id) {
		return techService.getById(id);
	}
	
	@GetMapping("/getbylanguage")
	public DataResult<List<Tech>> getByLanguage(@RequestParam int languageId){
		return techService.getByLanguage(languageId);
	}
}
