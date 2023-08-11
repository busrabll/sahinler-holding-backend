package sahinler.holding.socialMediaApp.business.abstracts;

import java.util.List;

import sahinler.holding.socialMediaApp.business.requests.CreateLikeRequest;
import sahinler.holding.socialMediaApp.business.responses.GetAllLikesResponse;

public interface LikeService {
	List<GetAllLikesResponse> getAll();
	void add(CreateLikeRequest createLikeRequest);
	void delete(int id);

}
