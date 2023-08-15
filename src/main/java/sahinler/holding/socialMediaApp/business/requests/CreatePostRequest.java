package sahinler.holding.socialMediaApp.business.requests;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePostRequest {
	
	private String text;
	private Date createDate;
	private int userId;
}
