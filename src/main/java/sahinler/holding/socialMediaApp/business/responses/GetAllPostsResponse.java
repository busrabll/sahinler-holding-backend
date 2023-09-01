package sahinler.holding.socialMediaApp.business.responses;

import java.util.Date;
import java.util.List;

import lombok.Data;
import sahinler.holding.socialMediaApp.model.Post;

@Data
public class GetAllPostsResponse {

	private int id;
	private String text;
	private Date createDate;
	private int userId;
	private String userName;
	
	private List<GetAllLikesResponse> postLikes;
	
	public GetAllPostsResponse(Post entity, List<GetAllLikesResponse> likes) {
		this.id = entity.getId();
		this.text = entity.getText();
		this.createDate = entity.getCreateDate();
		this.userId = entity.getUser().getId();
		this.userName = entity.getUser().getUserName();
		this.postLikes = likes;
	}
}
