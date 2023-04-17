package gilsonpjd.com.github.musiccollection.service;

import gilsonpjd.com.github.musiccollection.DTO.SongDto;
import gilsonpjd.com.github.musiccollection.model.Song;
import gilsonpjd.com.github.musiccollection.repository.SongRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class SongService {

    private final SongRepository songRepository;

    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public List<SongDto> SongsList() {
        List<Song> songs = songRepository.findAll();
        if (songs.isEmpty()) {
            throw new RuntimeException("empty list");
        }
        List<SongDto> songsDto = new ArrayList<>();
        for (Song song : songs) {
            SongDto songDto = new SongDto(song);
            songsDto.add(songDto);
        }
        return songsDto;
    }

    public SongDto SongById(Integer id) {
        SongDto songDto = new SongDto(songRepository.findById(id).get());
       if(songDto==null){
           throw new NoSuchElementException("User Not Found");
       }
       return songDto;
    }

    public SongDto CreatedSong(Song song) {
        SongDto songDto = new SongDto(song);
        CheckIfSongExists(songDto);
        SongDto songDtoSave = new SongDto(songRepository.save(song));
        return songDtoSave;
    }

    public SongDto UpdateSong(Integer id, Song song) {
        SongById(id);
        SongDto songDto = new SongDto(song);
        CheckIfSongExists(songDto);
        Song songUpdate = new Song();
        songUpdate.setId(id);
        songUpdate.setTitle(songDto.getTitle());
        songUpdate.setArtist(songDto.getArtist());
        songUpdate.setAlbum(songDto.getAlbum());
        songRepository.save(songUpdate);
        SongDto dto = new SongDto(songUpdate);
        return dto;
    }

    private void CheckIfSongExists(SongDto song) {
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
