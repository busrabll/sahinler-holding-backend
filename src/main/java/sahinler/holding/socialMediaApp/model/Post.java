package sahinler.holding.socialMediaApp.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="posts")
@Entity
@Builder
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="id")
	private int id;
	
	@Column(columnDefinition = "text")
	private String text;
	
	@Column(name="create_date")
	private Date createDate;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	
	@OneToMany(mappedBy="post"/*, cascade = CascadeType.ALL, orphanRemoval = true*/)
	private List<Like> likes;

}