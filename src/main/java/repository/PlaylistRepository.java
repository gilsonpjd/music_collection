package repository;

import model.Playlist;
import model.PlaylistsSongs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepository extends JpaRepository<Playlist,Integer>{
}
