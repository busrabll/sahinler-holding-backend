package sahinler.holding.socialMediaApp.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import sahinler.holding.socialMediaApp.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
