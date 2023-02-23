package kodlama.io.Devs.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "TECHS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Tech {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="techId")
	private int techId;
	
	@Column(name="techName")
	private String techName;
	
	@ManyToOne
	@JoinColumn(name="languageId", nullable=false)
	private Language language;
}
