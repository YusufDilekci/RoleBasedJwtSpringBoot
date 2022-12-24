package kodlama.io.Devs.entities;

import kodlama.io.Devs.entities.abstracts.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Language implements Entity {
	private int  languageId;
	private String languageName;
	private int popularity;
	private String whoCreator;
	
}
