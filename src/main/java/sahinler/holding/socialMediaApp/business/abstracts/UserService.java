package sahinler.holding.socialMediaApp.business.abstracts;

import sahinler.holding.socialMediaApp.business.responses.GetByIdUserResponse;

public interface UserService {
	
	GetByIdUserResponse getById(int id);
}
