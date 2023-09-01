package sahinler.holding.socialMediaApp.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sahinler.holding.socialMediaApp.model.Like;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllLikesResponse {

	private int id;
	private int userId;
	private int postId;

	public GetAllLikesResponse(Like entity) {
		this.id = entity.getId();
		this.userId = entity.getUser().getId();
		this.postId = entity.getPost().getId();
	}
}
