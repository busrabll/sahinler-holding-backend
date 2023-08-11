package sahinler.holding.socialMediaApp.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import sahinler.holding.socialMediaApp.model.Like;

public interface LikeRepository extends JpaRepository<Like, Integer> {

}
