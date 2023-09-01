package sahinler.holding.socialMediaApp.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sahinler.holding.socialMediaApp.model.Like;

public interface LikeRepository extends JpaRepository<Like, Integer> {
	
	List<Like> findByUserId(int userId);
	
	List<Like> findByPostId(int postId);
	
	List<Like> findByUserIdAndPostId(int userId, int postId);
}
