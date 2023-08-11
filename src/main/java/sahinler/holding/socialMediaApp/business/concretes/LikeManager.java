package sahinler.holding.socialMediaApp.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import sahinler.holding.socialMediaApp.business.abstracts.LikeService;
import sahinler.holding.socialMediaApp.business.requests.CreateLikeRequest;
import sahinler.holding.socialMediaApp.business.responses.GetAllLikesResponse;
import sahinler.holding.socialMediaApp.core.utilities.mappers.ModelMapperService;
import sahinler.holding.socialMediaApp.dataAccess.LikeRepository;
import sahinler.holding.socialMediaApp.model.Like;

@Service
@AllArgsConstructor
public class LikeManager implements LikeService {
	
	private LikeRepository likeRepository;
	private ModelMapperService modelMapperService;

	@Override
	public List<GetAllLikesResponse> getAll() {
		
		List<Like> likes = likeRepository.findAll();
		
		List<GetAllLikesResponse> likesResponse = likes.stream()
				.map(like -> this.modelMapperService.forResponse()
						.map(like, GetAllLikesResponse.class)).collect(Collectors.toList());
		return likesResponse;
	}

	@Override
	public void add(CreateLikeRequest createLikeRequest) {
		Like like = this.modelMapperService.forRequest()
				.map(createLikeRequest, Like.class);
		
		this.likeRepository.save(like);
	}

	@Override
	public void delete(int id) {
		this.likeRepository.deleteById(id);
	}

}
