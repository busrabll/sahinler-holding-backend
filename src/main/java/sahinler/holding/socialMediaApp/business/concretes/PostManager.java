package sahinler.holding.socialMediaApp.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import sahinler.holding.socialMediaApp.business.abstracts.PostService;
import sahinler.holding.socialMediaApp.business.requests.CreatePostRequest;
import sahinler.holding.socialMediaApp.business.requests.UpdatePostRequest;
import sahinler.holding.socialMediaApp.business.responses.GetAllPostsResponse;
import sahinler.holding.socialMediaApp.core.utilities.mappers.ModelMapperService;
import sahinler.holding.socialMediaApp.dataAccess.PostRepository;
import sahinler.holding.socialMediaApp.model.Post;

@Service
@AllArgsConstructor
public class PostManager implements PostService {

	private PostRepository postRepository;
	private ModelMapperService modelMapperService;

	@Override
	public List<GetAllPostsResponse> getAll() {

		List<Post> posts = postRepository.findAll();

		List<GetAllPostsResponse> postsResponse = posts.stream()
				.map(post -> this.modelMapperService.forResponse().map(post, GetAllPostsResponse.class))
				.collect(Collectors.toList());
		
		/*for (GetAllPostsResponse postsResponse : postsResponse) {
			
		}*/
		return postsResponse;
	}

	@Override
	public void add(CreatePostRequest createPostRequest) {
		Post post = this.modelMapperService.forRequest().map(createPostRequest, Post.class);

		this.postRepository.save(post);
		
	}

	@Override
	public void update(int id, UpdatePostRequest updatePostRequest) {
		Post post = this.modelMapperService.forRequest().map(updatePostRequest, Post.class);
		this.postRepository.save(post);
	}

	@Override
	public void delete(int id) {
		this.postRepository.deleteById(id);
	}

}
