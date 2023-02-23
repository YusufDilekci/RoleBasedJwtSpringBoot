package kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Devs.business.abstracts.UserService;
import kodlama.io.Devs.business.requests.AssignRoleRequest;
import kodlama.io.Devs.business.requests.CreateUserRequest;
import kodlama.io.Devs.business.requests.DeleteUserRequest;
import kodlama.io.Devs.business.requests.GetByMailRequest;
import kodlama.io.Devs.business.requests.UpdateUserRequest;
import kodlama.io.Devs.business.responses.GetAllUserResponse;
import kodlama.io.Devs.business.responses.GetUserResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor //final fields olmalılar
public class UsersController {
	
	private final UserService userService;
	
	@GetMapping("/getalluser")
	public ResponseEntity<List<GetAllUserResponse>> getall(){
		
		return ResponseEntity.ok(userService.getAll());
	}
	
	@GetMapping("/getbyemail")
	public ResponseEntity<GetUserResponse> getbyemail(@RequestBody GetByMailRequest request){
		
		return ResponseEntity.ok(userService.getByEmail(request));
	}
	
	@PostMapping("/assignrole")
	public ResponseEntity<?> assignuserrole(@RequestBody AssignRoleRequest request){
		
		return ResponseEntity.ok(userService.assignUserRole(request));
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody CreateUserRequest request){
		
		return ResponseEntity.ok(userService.add(request));
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody UpdateUserRequest request){
		
		return ResponseEntity.ok(userService.update(request));
	}
	
	@GetMapping("/delete/{userId}")
	public ResponseEntity<?> delete(@PathVariable("userId") int userId, DeleteUserRequest request){
		
		request.setId(userId);
		return ResponseEntity.ok(userService.delete(request));
	}
}
