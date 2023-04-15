package gilsonpjd.com.github.musiccollection.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import gilsonpjd.com.github.musiccollection.model.Song;
import gilsonpjd.com.github.musiccollection.model.User;
import jakarta.persistence.*;

import java.util.List;


public class PlaylistDto {

    private Integer id;
    private String title;
    private UserDto user;
    private List<SongDto> songs;

    public PlaylistDto(Integer id, String title, UserDto user, List<SongDto> songs) {
        this.id = id;
        this.title = title;
        this.user = user;
        this.songs = songs;
    }


    public PlaylistDto(Song song, User user, List<Song> songs) {
        id = song.getId();
        title = song.getTitle();
        user = user;
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

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public List<SongDto> getSongs() {
        return songs;
    }

    public void setSongs(List<SongDto> songs) {
        this.songs = songs;
    }
}
