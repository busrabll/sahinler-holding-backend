package sahinler.holding.socialMediaApp.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sahinler.holding.socialMediaApp.business.abstracts.PostService;
import sahinler.holding.socialMediaApp.business.requests.CreatePostRequest;
import sahinler.holding.socialMediaApp.business.responses.GetAllPostsResponse;
import sahinler.holding.socialMediaApp.dataAccess.PostRepository;
import sahinler.holding.socialMediaApp.model.Post;

@Service
public class PostManager implements PostService {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private ModelMapper mapper;

	@Override
	public List<GetAllPostsResponse> getAll() {

		List<Post> posts = postRepository.findAll();
		List<GetAllPostsResponse> postsResponse = posts.stream()
				.map(post -> mapper.map(post, GetAllPostsResponse.class)).collect(Collectors.toList());
		return postsResponse;

	}

	@Override
	public GetAllPostsResponse getPostById(int id) {
		Optional<Post> post = postRepository.findById(id);
		GetAllPostsResponse postResponse = mapper.map(post, GetAllPostsResponse.class);
		return postResponse;
	}

	@Override
	public Post add(CreatePostRequest createPostRequest) {
		Post post = mapper.map(createPostRequest, Post.class);

		return this.postRepository.save(post);

	}

	@Override
	public void delete(int id) {
		this.postRepository.deleteById(id);
	}

	/*
	 * @Override public Post update(UpdatePostRequest updatePostRequest, int id) {
	 * Post post = mapper.map(updatePostRequest, Post.class);
	 * 
	 * /*if (Objects.nonNull( updatePostRequest.getText()) && !"".equalsIgnoreCase(
	 * updatePostRequest.getText())) { post.setText( updatePostRequest.getText()); }
	 * 
	 * if (Objects.nonNull(updatePostRequest.getCreateDate()) &&
	 * !"".equalsIgnoreCase(updatePostRequest.getCreateDate())) {
	 * post.setCreateDate(updatePostRequest.getCreateDate()); }
	 * 
	 * return this.postRepository.save(post); }
	 */

}
