package kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Devs.business.requests.AssignRoleRequest;
import kodlama.io.Devs.business.requests.CreateUserRequest;
import kodlama.io.Devs.business.requests.DeleteUserRequest;
import kodlama.io.Devs.business.requests.GetByMailRequest;
import kodlama.io.Devs.business.requests.UpdateUserRequest;
import kodlama.io.Devs.business.responses.GetAllUserResponse;
import kodlama.io.Devs.business.responses.GetUserResponse;
import kodlama.io.Devs.core.utilities.results.Result;

public interface UserService {
	List<GetAllUserResponse> getAll();
	GetUserResponse getByEmail(GetByMailRequest request);
	Result assignUserRole(AssignRoleRequest request);
	Result add(CreateUserRequest request);
	Result update(UpdateUserRequest request);
	Result delete(DeleteUserRequest request);
	
}
