package sahinler.holding.socialMediaApp.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sahinler.holding.socialMediaApp.business.abstracts.LikeService;
import sahinler.holding.socialMediaApp.business.requests.CreateLikeRequest;
import sahinler.holding.socialMediaApp.business.responses.GetAllLikesResponse;
import sahinler.holding.socialMediaApp.dataAccess.LikeRepository;
import sahinler.holding.socialMediaApp.model.Like;

@Service
public class LikeManager implements LikeService {

	@Autowired
	private LikeRepository likeRepository;

	@Autowired
	private ModelMapper mapper;

	@Override
	public List<GetAllLikesResponse> getAll() {
		List<Like> likes = likeRepository.findAll();
		List<GetAllLikesResponse> likesResponse = likes.stream()
				.map(like -> mapper.map(like, GetAllLikesResponse.class)).collect(Collectors.toList());
		return likesResponse;
	}

	@Override
	public Like add(CreateLikeRequest createLikeRequest) {
		Like like = mapper.map(createLikeRequest, Like.class);

		return this.likeRepository.save(like);
	}

	@Override
	public void delete(int id) {
		this.likeRepository.deleteById(id);
	}
}
