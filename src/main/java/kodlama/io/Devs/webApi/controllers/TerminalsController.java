package kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Devs.business.abstracts.TerminalService;
import kodlama.io.Devs.entities.Terminal;
import lombok.RequiredArgsConstructor;

@RestController //annotation
@RequestMapping("/api/terminals")
@RequiredArgsConstructor // dependency injection için gerekli constructorı oluşturur.
public class TerminalsController {
	
	private final TerminalService terminalService;
	
	@GetMapping("/get-terminals")
	public ResponseEntity<List<Terminal>> getall(){
		
		return ResponseEntity.ok(terminalService.getTerminals());
	}
}
