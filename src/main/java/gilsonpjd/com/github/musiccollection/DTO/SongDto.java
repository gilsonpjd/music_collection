package gilsonpjd.com.github.musiccollection.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import gilsonpjd.com.github.musiccollection.model.Song;
import jakarta.persistence.*;

import java.util.List;

public class SongDto {

    private Integer id;
    private String title;
    private String artist;
    private String album;

    public SongDto(Integer id, String title, String artist, String album) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.album = album;
    }

    public SongDto(Song song) {
     id = song.getId();
     title = song.getTitle();
     artist = song.getArtist();
     album = song.getAlbum();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }
}
