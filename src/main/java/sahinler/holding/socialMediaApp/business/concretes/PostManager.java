package sahinler.holding.socialMediaApp.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sahinler.holding.socialMediaApp.business.abstracts.PostService;
import sahinler.holding.socialMediaApp.business.requests.CreatePostRequest;
import sahinler.holding.socialMediaApp.business.requests.UpdatePostRequest;
import sahinler.holding.socialMediaApp.business.responses.GetAllPostsResponse;
import sahinler.holding.socialMediaApp.dataAccess.PostRepository;
import sahinler.holding.socialMediaApp.model.Post;

@Service
public class PostManager implements PostService {

	@Autowired
	private PostRepository postRepository;
	
	/*
	 * @Autowired private ModelMapper mapper;
	 */

	ModelMapper mapper = new ModelMapper();

	@Override
	public List<GetAllPostsResponse> getAll() {

		List<Post> posts = postRepository.findAll();
		List<GetAllPostsResponse> postsResponse = posts.stream()
				.map(post -> this.mapper.map(post, GetAllPostsResponse.class)).collect(Collectors.toList());
		return postsResponse;

	}

	@Override
	public GetAllPostsResponse getPostById(int id) {
		Optional<Post> post = postRepository.findById(id);
		GetAllPostsResponse postResponse = this.mapper.map(post, GetAllPostsResponse.class);
		return postResponse;
	}

	@Override
	public Post add(CreatePostRequest createPostRequest) {

		mapper.getConfiguration().setAmbiguityIgnored(true);

		/*
		 * mapper.createTypeMap(CreatePostRequest.class,
		 * Post.class).addMapping(CreatePostRequest::getId, Post::setId);
		 */

		Post post = this.mapper.map(createPostRequest, Post.class);

		return this.postRepository.save(post);

	}

	@Override
	public Post update(UpdatePostRequest updatePostRequest, int id) {
		Post post = this.mapper.map(updatePostRequest, Post.class);
		return this.postRepository.save(post);
	}

	@Override
	public void delete(int id) {
		this.postRepository.deleteById(id);
	}

}
