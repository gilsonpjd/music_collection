package service;
import model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.SongRepository;
import java.util.List;
@Service

public class SongService {
    @Autowired
    private SongRepository songRepository;

    public List<Song> SongsList(){
        return songRepository.findAll();
    }
    public Song SongById(Integer id){
        return songRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Song Not Found"));
    }
    public Song CreatedSong (Song song){
        return songRepository.save(song);
    }
    public Song UpdateSong(Integer id, Song song){
        Song songUpdate = SongById(id);
        songUpdate.setTitle(song.getTitle());
        return songRepository.save(songUpdate);
    }
    public void DeleteSong(Integer id){
        songRepository.deleteById(id);
    }

}
