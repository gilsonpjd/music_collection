package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "songs")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Song {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;

   @Column(name = "title")
   private String title;

   @Column(name = "artist")
   private String artist;

   @Column(name = "album")
   private String album;

   List<PlaylistsSongs> playlistsSongs;
}
