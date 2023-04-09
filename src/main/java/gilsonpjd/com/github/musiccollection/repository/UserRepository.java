package gilsonpjd.com.github.musiccollection.repository;

import gilsonpjd.com.github.musiccollection.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepository extends JpaRepository<User, Integer> {

}

