package gilsonpjd.com.github.musiccollection.repository;

import gilsonpjd.com.github.musiccollection.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PlaylistRepository extends JpaRepository<Playlist,Integer>{
}
