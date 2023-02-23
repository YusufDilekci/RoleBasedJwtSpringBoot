package kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstracts.TerminalService;
import kodlama.io.Devs.dataAccess.abstracts.TerminalRepository;
import kodlama.io.Devs.entities.Terminal;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // dependency injection için gerekli constructorı oluşturur.
public class TerminalManager implements TerminalService{
	
	private final TerminalRepository terminalRepository;
	
	@Override
	public List<Terminal> getTerminals() {
		
		return terminalRepository.findAll();
				
	}
}
