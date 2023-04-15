package gilsonpjd.com.github.musiccollection.controller;

import gilsonpjd.com.github.musiccollection.model.Playlist;
import gilsonpjd.com.github.musiccollection.service.PlaylistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/playlists")
public class PlaylistController {

    private final PlaylistService playlistService;

    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }
    @PostMapping("/{id}")
    public ResponseEntity<Playlist> CreatedPlayList(@PathVariable Integer id_user, @RequestBody Playlist playlist) {
        return new ResponseEntity<>
                (playlistService.CreatedPlaysList(playlist, id_user),
                        HttpStatus.CREATED);
    }
//    @GetMapping({"/idUser"})
//    public ResponseEntity PlaylistByIdUser(@PathVariable Integer id_user) {
//        return ResponseEntity.ok(playlistService.PlaylistByIdUser(id_user));
//    }


//    @PutMapping("/{id}")
//    public ResponseEntity<Playlist> UpdatePlayList(@PathVariable Integer id, @RequestBody Playlist playlist) {
//        return ResponseEntity.ok(playlistService.UpdatePlayList(id, playlist));
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Playlist> DeletePlaysList(@PathVariable Integer id) {
        playlistService.DeletePlayList(id);
        return ResponseEntity.noContent().build();
    }


}
