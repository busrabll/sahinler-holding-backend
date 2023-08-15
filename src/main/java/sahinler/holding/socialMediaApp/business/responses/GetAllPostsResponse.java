package sahinler.holding.socialMediaApp.business.responses;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllPostsResponse {

	private int id;
	private String text;
	private Date createDate;
	private int userId;
	private String userName;

}
