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

    Songs id_song = getId_song();
    Playlist id_playlist = getId_playlist();

}
