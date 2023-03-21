package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "playlists")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name = "id_user")
    User id_user = getId_user();

    @Column (name = "title")
    private String title;

    List<Song> playlistsSongs;

    //Song id_song = getId_song();
    //Playlist id_playlist = getId_playlist();
}
