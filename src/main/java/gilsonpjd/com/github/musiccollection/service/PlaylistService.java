package gilsonpjd.com.github.musiccollection.service;

import gilsonpjd.com.github.musiccollection.model.Playlist;
import gilsonpjd.com.github.musiccollection.repository.PlaylistRepository;
import gilsonpjd.com.github.musiccollection.repository.SongRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistService {

    private final SongRepository songRepository;
    private final PlaylistRepository playlistRepository;

    public PlaylistService(SongRepository songRepository, PlaylistRepository playlistRepository) {
        this.songRepository = songRepository;
        this.playlistRepository = playlistRepository;
    }

    public List<Playlist> PlaylistAll() {
        List<Playlist> playlist = playlistRepository.findAll();
        if (playlist.isEmpty()) {
            throw new RuntimeException("Empty playlist");
        }
        return playlist;
    }

    public Playlist PlaylistById(Integer id) {
        return playlistRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Playslist Not Found"));
    }

    public Playlist CreatedPlaysList(Playlist playlist) {
        return playlistRepository.save(playlist);
    }

    public Playlist UpdatePlayList(Integer id, Playlist playlistlist) {
        Playlist updatePlaylist = PlaylistById(id);
        CheckIfPlaylistExists(playlistlist);
        updatePlaylist.setTitle(playlistlist.getTitle());
        return playlistRepository.save(updatePlaylist);
    }

    private void CheckIfPlaylistExists(Playlist playlistlist) {
        List<Playlist> playlists = playlistRepository.findAll();
        for (Playlist playlistAux : playlists) {
            if (playlistAux.getTitle().equals(playlistAux.getTitle())) {
                throw new RuntimeException("Playlist not found");
            }
        }
    }

    public void DeletePlayList(Integer id) {
        playlistRepository.findById(id);
        playlistRepository.deleteById(id);
    }
}
