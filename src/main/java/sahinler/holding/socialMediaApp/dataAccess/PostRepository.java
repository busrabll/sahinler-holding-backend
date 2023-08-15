package sahinler.holding.socialMediaApp.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import sahinler.holding.socialMediaApp.model.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
