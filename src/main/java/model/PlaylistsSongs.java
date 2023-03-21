package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "playslists_songs")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class PlaylistsSongs {

    @Column(name = "id_song")
    Song id_song = getId_song();

    @Column(name = "id_playlist")
    Playlist id_playlist = getId_playlist();

}
