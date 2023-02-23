package kodlama.io.Devs.business.abstracts;

import kodlama.io.Devs.business.requests.AuthenticationRequest;
import kodlama.io.Devs.business.requests.RegisterRequest;
import kodlama.io.Devs.business.responses.AuthenticationResponse;



public interface AuthService {

	AuthenticationResponse register(RegisterRequest request);
	AuthenticationResponse authenticate(AuthenticationRequest request);
}
