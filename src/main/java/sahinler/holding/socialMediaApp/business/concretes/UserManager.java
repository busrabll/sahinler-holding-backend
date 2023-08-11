package sahinler.holding.socialMediaApp.business.concretes;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import sahinler.holding.socialMediaApp.business.abstracts.UserService;
import sahinler.holding.socialMediaApp.business.responses.GetByIdUserResponse;
import sahinler.holding.socialMediaApp.core.utilities.mappers.ModelMapperService;
import sahinler.holding.socialMediaApp.dataAccess.UserRepository;
import sahinler.holding.socialMediaApp.model.User;

@Service
@AllArgsConstructor
public class UserManager implements UserService {
	
	private UserRepository userRepository;
	private ModelMapperService modelMapperService;

	@Override
	public GetByIdUserResponse getById(int id) {
		User user = this.userRepository.findById(id).orElseThrow();
		
		GetByIdUserResponse response = this.modelMapperService.forResponse().map(user, GetByIdUserResponse.class);
		
		return response;
	}
}
