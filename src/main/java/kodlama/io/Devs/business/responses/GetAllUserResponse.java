package kodlama.io.Devs.business.responses;

import java.util.Set;

import kodlama.io.Devs.core.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetAllUserResponse {
	private int id;
	private String firstname;
	private String lastname;
	private String email;
	private Set<Role> roles;
}
