package sahinler.holding.socialMediaApp.business.abstracts;

import java.util.List;

import sahinler.holding.socialMediaApp.business.requests.CreatePostRequest;
import sahinler.holding.socialMediaApp.business.responses.GetAllPostsResponse;
import sahinler.holding.socialMediaApp.model.Post;

public interface PostService {

	List<GetAllPostsResponse> getAll();
	
	GetAllPostsResponse getPostById(int id);

	Post add(CreatePostRequest createPostRequest);

	/*Post update(UpdatePostRequest updatePostRequest, int id);*/

	void delete(int id);

}
