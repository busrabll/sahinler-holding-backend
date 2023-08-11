package sahinler.holding.socialMediaApp.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sahinler.holding.socialMediaApp.model.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

	List<Post> findByUserId(int userId);
}
