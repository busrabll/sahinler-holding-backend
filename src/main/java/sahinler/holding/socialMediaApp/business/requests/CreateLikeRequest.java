package sahinler.holding.socialMediaApp.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateLikeRequest {
	
	private int id;
	private int userId;
	private int postId;
}
