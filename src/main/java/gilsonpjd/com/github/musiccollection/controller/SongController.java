package gilsonpjd.com.github.musiccollection.controller;

import gilsonpjd.com.github.musiccollection.DTO.SongDto;
import gilsonpjd.com.github.musiccollection.model.Song;
import gilsonpjd.com.github.musiccollection.service.SongService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/songs")
public class SongController {

    private final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping
    public ResponseEntity<List<SongDto>> SongsList() {
        List<SongDto> song = songService.SongsList();
        return ResponseEntity
                .ok(song);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SongDto> SongById(@PathVariable Integer id) {
        return ResponseEntity
                .ok(songService.SongById(id));
    }

    @PostMapping
    public ResponseEntity<SongDto> CreatedSong(@RequestBody Song song) {
        return new ResponseEntity<>
                (songService.CreatedSong(song), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SongDto> UpdateSong(@PathVariable Integer id, @RequestBody Song song) {
        return ResponseEntity.ok(songService.UpdateSong(id, song));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SongDto> DeleteSong(@PathVariable Integer id) {
        songService.DeleteSong(id);
        return ResponseEntity.noContent().build();
    }

}
