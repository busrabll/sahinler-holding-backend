package sahinler.holding.socialMediaApp.business.abstracts;

import java.util.List;

import sahinler.holding.socialMediaApp.business.requests.CreatePostRequest;
import sahinler.holding.socialMediaApp.business.requests.UpdatePostRequest;
import sahinler.holding.socialMediaApp.business.responses.GetAllPostsResponse;

public interface PostService {
	List<GetAllPostsResponse> getAll();
	void add(CreatePostRequest createPostRequest);
	void update(int id, UpdatePostRequest updatePostRequest);
	void delete(int id);

}
