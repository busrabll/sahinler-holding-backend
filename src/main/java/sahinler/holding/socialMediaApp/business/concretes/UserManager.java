package sahinler.holding.socialMediaApp.business.concretes;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sahinler.holding.socialMediaApp.business.abstracts.UserService;
import sahinler.holding.socialMediaApp.dataAccess.UserRepository;
import sahinler.holding.socialMediaApp.model.User;

@Service
public class UserManager implements UserService {

	@Autowired
	private UserRepository userRepository;

	ModelMapper mapper = new ModelMapper();

	@Override
	/*
	 * public GetAllUsersResponse getUserById(int id) { Optional<User> user =
	 * userRepository.findById(id); GetAllUsersResponse userResponse =
	 * this.mapper.map(user, GetAllUsersResponse.class); return userResponse; }
	 */
	public User getUserById(int id) {	
		return userRepository.findById(id).orElse(null);
	}
}
