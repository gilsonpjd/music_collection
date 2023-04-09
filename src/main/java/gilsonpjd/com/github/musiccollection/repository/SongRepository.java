package gilsonpjd.com.github.musiccollection.repository;

import gilsonpjd.com.github.musiccollection.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository <Song, Integer> {
}
