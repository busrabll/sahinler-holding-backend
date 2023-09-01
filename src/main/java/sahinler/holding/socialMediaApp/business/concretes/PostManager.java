package sahinler.holding.socialMediaApp.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import sahinler.holding.socialMediaApp.business.abstracts.LikeService;
import sahinler.holding.socialMediaApp.business.abstracts.PostService;
import sahinler.holding.socialMediaApp.business.requests.CreatePostRequest;
import sahinler.holding.socialMediaApp.business.requests.UpdatePostRequest;
import sahinler.holding.socialMediaApp.business.responses.GetAllLikesResponse;
import sahinler.holding.socialMediaApp.business.responses.GetAllPostsResponse;
import sahinler.holding.socialMediaApp.dataAccess.PostRepository;
import sahinler.holding.socialMediaApp.model.Post;

@Service
@AllArgsConstructor
public class PostManager implements PostService {

	private PostRepository postRepository;

	private LikeService likeService;

	@Autowired
	public void setLikeService(LikeService likeService) {
		this.likeService = likeService;
	}

	/*
	 * @Autowired private ModelMapper mapper;
	 */

	ModelMapper mapper = new ModelMapper();

	@Override
	public List<GetAllPostsResponse> getAll() {

		List<Post> posts;
		posts = postRepository.findAll();

		return posts.stream().map(p -> {
			List<GetAllLikesResponse> likes = likeService.getAll(Optional.ofNullable(null), Optional.of(p.getId()));
			return new GetAllPostsResponse(p, likes);
		}).collect(Collectors.toList());

		/*
		 * List<Post> posts = postRepository.findAll(); List<GetAllPostsResponse>
		 * postsResponse = posts.stream() .map(post -> this.mapper.map(post,
		 * GetAllPostsResponse.class)).collect(Collectors.toList()); return
		 * postsResponse;
		 */
	}

	/*
	 * public GetAllPostsResponse getPostById(int id) { Optional<Post> post =
	 * postRepository.findById(id); GetAllPostsResponse postResponse =
	 * this.mapper.map(post, GetAllPostsResponse.class); return postResponse; }
	 */

	@Override
	public Post getPostById(int id) {
		return postRepository.findById(id).orElse(null);
	}

	@Override
	public Post add(CreatePostRequest createPostRequest) {

		mapper.getConfiguration().setAmbiguityIgnored(true);

		Post post = this.mapper.map(createPostRequest, Post.class);
		return this.postRepository.save(post);

		/*
		 * mapper.createTypeMap(CreatePostRequest.class,
		 * Post.class).addMapping(CreatePostRequest::getId, Post::setId);
		 */
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
