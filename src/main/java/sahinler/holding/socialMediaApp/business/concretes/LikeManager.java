package sahinler.holding.socialMediaApp.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import sahinler.holding.socialMediaApp.business.abstracts.LikeService;
import sahinler.holding.socialMediaApp.business.abstracts.UserService;
import sahinler.holding.socialMediaApp.business.requests.CreateLikeRequest;
import sahinler.holding.socialMediaApp.business.responses.GetAllLikesResponse;
import sahinler.holding.socialMediaApp.dataAccess.LikeRepository;
import sahinler.holding.socialMediaApp.dataAccess.PostRepository;
import sahinler.holding.socialMediaApp.model.Like;
import sahinler.holding.socialMediaApp.model.Post;
import sahinler.holding.socialMediaApp.model.User;

@Service
@AllArgsConstructor
public class LikeManager implements LikeService {

	private LikeRepository likeRepository;
	private UserService userService;
	private PostRepository postRepository;
	/* private ModelMapper mapper; */

	@Override
	public List<GetAllLikesResponse> getAll(Optional<Integer> userId, Optional<Integer> postId) {

		List<Like> likes;

		if (userId.isPresent() && postId.isPresent()) {
			likes = likeRepository.findByUserIdAndPostId(userId.get(), postId.get());
		} else if (userId.isPresent()) {
			likes = likeRepository.findByUserId(userId.get());
		} else if (postId.isPresent()) {
			likes = likeRepository.findByPostId(postId.get());
		} else {
			likes = likeRepository.findAll();
		}
		return likes.stream().map(like -> new GetAllLikesResponse(like)).collect(Collectors.toList());

		/*
		 * List<Like> likes = likeRepository.findAll(); List<GetAllLikesResponse>
		 * likesResponse = likes.stream() .map(like -> mapper.map(like,
		 * GetAllLikesResponse.class)).collect(Collectors.toList()); return
		 * likesResponse;
		 */

		/*
		 * List<Like> likes; likes = likeRepository.findAll();
		 * 
		 * return likes.stream().map(like -> new
		 * GetAllLikesResponse(like)).collect(Collectors.toList());
		 */
	}

	@Override
	public Like add(CreateLikeRequest createLikeRequest) {

		/*
		 * mapper.getConfiguration().setAmbiguityIgnored(true); Like like =
		 * mapper.map(createLikeRequest, Like.class);
		 * 
		 * return this.likeRepository.save(like);
		 */

		User user = userService.getUserById(createLikeRequest.getUserId());
		Post post = postRepository.findById(createLikeRequest.getPostId()).orElse(null);

		Like likeToSave = new Like();
		likeToSave.setId(createLikeRequest.getId());
		likeToSave.setPost(post);
		likeToSave.setUser(user);
		return likeRepository.save(likeToSave);
	}

	@Override
	public void delete(int id) {
		this.likeRepository.deleteById(id);
	}
}
