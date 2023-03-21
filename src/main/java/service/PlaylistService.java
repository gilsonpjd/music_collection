package service;
import model.Playlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PlaylistRepository;
import repository.SongRepository;

import java.util.List;

@Service

public class PlaylistService {

    @Autowired
    private SongRepository songRepository;
    @Autowired
    private PlaylistRepository playlistRepository;

    public List<Playlist> PlaylistAll(){
        return playlistRepository.findAll();
    }
    public Playlist PlaylistById(Integer id){
        return playlistRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Playslist Not Found"));
    }
    public Playlist CreatedPlaysList(Playlist playlist){
        return playlistRepository.save(playlist);
    }
    public Playlist UpdatePlayList(Integer id, Playlist playlistlist){
       Playlist updatePlaylist = PlaylistById(id);
        updatePlaylist.setTitle(playlistlist.getTitle());
       return playlistRepository.save(updatePlaylist);
    }

    public void DeletePlayList(Integer id){
        playlistRepository.deleteById(id);
    }
}
