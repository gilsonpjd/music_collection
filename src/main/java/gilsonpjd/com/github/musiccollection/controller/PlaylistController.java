package gilsonpjd.com.github.musiccollection.controller;

import gilsonpjd.com.github.musiccollection.model.Playlist;
import gilsonpjd.com.github.musiccollection.service.PlaylistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/playlist")
public class PlaylistController {

    private final PlaylistService playlistService;

    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @GetMapping
    public ResponseEntity<List<Playlist>> PlaylistAll() {
        return ResponseEntity.ok(playlistService.PlaylistAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Playlist> PlaylistById(@PathVariable Integer id) {
        return ResponseEntity.ok(playlistService.PlaylistById(id));
    }

    @PostMapping
    public ResponseEntity<Playlist> CreatedPlayList(Playlist playlist) {
        return new ResponseEntity<>
                (playlistService.CreatedPlaysList(playlist),
                        HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Playlist> UpdatePlayList(@PathVariable Integer id, @RequestBody Playlist playlist) {
        return ResponseEntity.ok(playlistService.UpdatePlayList(id, playlist));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Playlist> DeletePlaysList(@PathVariable Integer id) {
        playlistService.DeletePlayList(id);
        return ResponseEntity.noContent().build();
    }


}
