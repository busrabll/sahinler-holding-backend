package sahinler.holding.socialMediaApp.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllLikesResponse {
	private int id;
	private int userId;
	private int postId;

}
