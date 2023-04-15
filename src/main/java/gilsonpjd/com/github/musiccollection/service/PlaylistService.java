package gilsonpjd.com.github.musiccollection.service;

import gilsonpjd.com.github.musiccollection.model.Playlist;
import gilsonpjd.com.github.musiccollection.model.User;
import gilsonpjd.com.github.musiccollection.repository.PlaylistRepository;
import gilsonpjd.com.github.musiccollection.repository.SongRepository;
import gilsonpjd.com.github.musiccollection.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlaylistService {

    private final SongRepository songRepository;
    private final PlaylistRepository playlistRepository;
    private final UserRepository userRepository;

    public PlaylistService(SongRepository songRepository, PlaylistRepository playlistRepository, UserRepository userRepository) {
        this.songRepository = songRepository;
        this.playlistRepository = playlistRepository;
        this.userRepository = userRepository;
    }

    public Playlist CreatedPlaysList(Playlist playlist, Integer id_user) {
        User user = getUser(id_user);
        Playlist userPlaylist = new Playlist();
        userPlaylist.setTitle(playlist.getTitle());
        userPlaylist.setUser(user);
        return playlistRepository.save(userPlaylist);
    }
    public Object PlaylistByIdUser(Integer id_user) {
        User user = getUser(id_user);
        return user.getPlaylistList();

    }
    public void DeletePlayList(Integer id) {
        playlistRepository.findById(id);
        playlistRepository.deleteById(id);
    }
    private User getUser(Integer id_user) {
        User user = userRepository.findById(id_user)
                .orElseThrow(() -> new RuntimeException("User ot Found"));
        return user;
    }


}
