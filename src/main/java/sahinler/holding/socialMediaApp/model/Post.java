package sahinler.holding.socialMediaApp.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="posts")
@Entity
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="id")
	private int id;
	
	@Column(columnDefinition = "text")
	private String text;
	
	@Column(name="create_date")
	private Date createDate;
	
	//@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name="user_id")
	//private User user;
	@Column(name="user_id")
	private int userId;
	
	@OneToMany(mappedBy="post")
	private List<Like> likes;

}
