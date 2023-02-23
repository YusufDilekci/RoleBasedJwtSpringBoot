package kodlama.io.Devs.entities;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="LANGUAGES")
@Entity

public class Language {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int  languageId;
	
	@Column(name = "languageName")
	private String languageName;
	
	@Column(name = "popularity")
	private int popularity;
	
	@Column(name = "whoCreator")
	private String whoCreator;
	
	@OneToMany(mappedBy="language")
	private Set<Tech> techs;
	
}
