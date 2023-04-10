package gilsonpjd.com.github.musiccollection.service;

import gilsonpjd.com.github.musiccollection.model.Song;
import gilsonpjd.com.github.musiccollection.repository.SongRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {

    private final SongRepository songRepository;

    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public List<Song> SongsList() {
        List<Song> songs = songRepository.findAll();
        if (songs.isEmpty()) {
            throw new RuntimeException("empty list");
        }
        return songs;
    }

    public Song SongById(Integer id) {
        return songRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Song Not Found"));
    }

    public Song CreatedSong(Song song) {
        CheckIfSongExists(song);
        return songRepository.save(song);
    }

    public Song UpdateSong(Integer id, Song song) {
        Song songUpdate = SongById(id);
        CheckIfSongExists(song);
        songUpdate.setTitle(song.getTitle());
        songUpdate.setArtist(song.getArtist());
        songUpdate.setAlbum(song.getAlbum());
        return songRepository.save(song);
    }

    private void CheckIfSongExists(Song song) {
        List<Song> songs = songRepository.findAll();
        for (Song songAux : songs) {
            if (songAux.getTitle().equals(song.getTitle())) {
                throw new RuntimeException("Title already exists");
            }
        }
    }

    public void DeleteSong(Integer id) {
        SongById(id);
        songRepository.deleteById(id);
    }

}
