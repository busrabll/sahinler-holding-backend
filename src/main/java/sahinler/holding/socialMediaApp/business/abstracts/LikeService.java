package sahinler.holding.socialMediaApp.business.abstracts;

import java.util.List;
import java.util.Optional;

import sahinler.holding.socialMediaApp.business.requests.CreateLikeRequest;
import sahinler.holding.socialMediaApp.business.responses.GetAllLikesResponse;
import sahinler.holding.socialMediaApp.model.Like;

public interface LikeService {

	List<GetAllLikesResponse> getAll(Optional<Integer> userId, Optional<Integer> postId);

	Like add(CreateLikeRequest createLikeRequest);

	void delete(int id);
}
