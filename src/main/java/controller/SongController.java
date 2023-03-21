package controller;
import model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.SongService;

import java.util.List;

@RestController
@RequestMapping("/song")

public class SongController {
    @Autowired
    private SongService songService;

    @GetMapping
    public ResponseEntity<List<Song>> SongsList(){
        List<Song> song = songService.SongsList();
        return ResponseEntity
                .ok(song);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Song> SongById(@PathVariable Integer id){
        return ResponseEntity
                .ok(songService.SongById(id));
    }
    @PostMapping
    public ResponseEntity<Song> CreatedSong (@RequestBody Song song){
        return new ResponseEntity<>
                (songService.CreatedSong(song), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Song> UpdateSong(@PathVariable Integer id, @RequestBody Song song){
        return ResponseEntity.ok(songService.UpdateSong(id, song));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Song> DeleteSong(@PathVariable Integer id){
        songService.DeleteSong(id);
        return ResponseEntity.noContent().build();
    }

}
