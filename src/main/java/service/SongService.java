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
        List<Song>songs = songRepository.findAll();
        if(songs.isEmpty()){
            throw new RuntimeException ("empty list");
        }
        return songs;
    }
    public Song SongById(Integer id){
        return songRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Song Not Found"));
    }
    public Song CreatedSong (Song song){
        CheckIfSongExists(song);
        return songRepository.save(song);
    }
    public Song UpdateSong(Integer id, Song song){
        Song songUpdate = SongById(id);
        CheckIfSongExists(song);
        songUpdate.setTitle(song.getTitle());
        return songRepository.save(songUpdate);
    }

    private void CheckIfSongExists(Song song) {
        List<Song> songs = songRepository.findAll();
        for (Song songAux :songs) {
            if(songAux.getTitle().equals(song.getTitle())){
                throw new RuntimeException("Title already exists");
            }
        }
    }

    public void DeleteSong(Integer id){
        SongById(id);
        songRepository.deleteById(id);
    }

}
