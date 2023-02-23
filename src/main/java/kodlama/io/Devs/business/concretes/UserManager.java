package kodlama.io.Devs.business.concretes;



import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstracts.UserService;
import kodlama.io.Devs.business.requests.AssignRoleRequest;
import kodlama.io.Devs.business.requests.CreateUserRequest;
import kodlama.io.Devs.business.requests.DeleteUserRequest;
import kodlama.io.Devs.business.requests.GetByMailRequest;
import kodlama.io.Devs.business.requests.UpdateUserRequest;
import kodlama.io.Devs.business.responses.GetAllUserResponse;
import kodlama.io.Devs.business.responses.GetUserResponse;
import kodlama.io.Devs.core.entities.Role;
import kodlama.io.Devs.core.entities.User;
import kodlama.io.Devs.core.utilities.mappers.ModelMapperService;
import kodlama.io.Devs.core.utilities.results.ErrorResult;
import kodlama.io.Devs.core.utilities.results.Result;
import kodlama.io.Devs.core.utilities.results.SuccessResult;
import kodlama.io.Devs.dataAccess.abstracts.RoleRepository;
import kodlama.io.Devs.dataAccess.abstracts.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserManager implements UserService{
	
	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	private final ModelMapperService modelMapperService;
	private final PasswordEncoder passwordEncoder;
	
	
	public List<GetAllUserResponse> getAll() {
		var users = userRepository.findAll();
		
		List<GetAllUserResponse> response= users.stream()
				.map(user -> this.modelMapperService.forResponse().map(user, GetAllUserResponse.class))
				.collect(Collectors.toList());
		
		return response;
	}
	
	public GetUserResponse getByEmail(GetByMailRequest request) {
		
		var user = userRepository.findByEmail(request.getEmail()).orElseThrow();
		
		GetUserResponse response = this.modelMapperService.forResponse().map(user, GetUserResponse.class);
		
		return response;
	}
	
	public Result assignUserRole(AssignRoleRequest request) {
		var user = userRepository.findByEmail(request.getEmail()).get();
		
		var roles = toSetRole(request.getRoles());
		
		for(var r: roles) {
			var role = roleRepository.findByName(r.toString());
			if(role == null) {
				
				return new ErrorResult("Role eklenemedi lütfen geçerli rol giriniz.");
			}
			user.addRole(role);
		}
		
		
		userRepository.save(user);
		return new SuccessResult("Role eklendi");
		
		
		
	}

	@Override
	public Result add(CreateUserRequest request) {
		User user  = new User();
		
		user.setRoles(toSetRole(request.getRoles()));
		user.setFirstname(request.getFirstname());
		user.setLastname(request.getLastname());
		user.setEmail(request.getEmail());
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		
		userRepository.save(user);
		
		
		return new SuccessResult("Kullanıcı eklendi"); 
	}
	
	private Set<Role> toSetRole(String[] roles){
		Set<Role> arr= new HashSet<>();
		for(int i=0; i < roles.length; i++) {
			var role = roleRepository.findByName(roles[i]);
			arr.add(role);
		}
		
		return arr;
		
	}

	@Override
	public Result update(UpdateUserRequest request) {

		User user = userRepository.findById(request.getId()).orElseThrow();
		
		user.setEmail(request.getEmail());
		user.setFirstname(request.getFirstname());
		user.setLastname(request.getLastname());
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		user.setRoles(toSetRole(request.getRoles()));
		
		userRepository.save(user);
		
		return new SuccessResult("Kullanıcı başarılı bir şekilde güncellendi");
	}

	@Override
	public Result delete(DeleteUserRequest request) {
		
		userRepository.deleteById(request.getId());
		return new SuccessResult("Kullanıcı başarıyla soft silindi");
	}


}
