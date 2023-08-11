package sahinler.holding.socialMediaApp.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePostRequest {

	private int id;
	private String text;
	//private Date createDate;

}
