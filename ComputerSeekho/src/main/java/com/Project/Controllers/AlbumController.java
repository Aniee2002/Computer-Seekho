package com.Project.Controllers;

import com.Project.Entities.Album;
import com.Project.Services.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/albums")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    // Add a new album
    @PostMapping
    public ResponseEntity<Album> createAlbum(@RequestBody Album album) {
        Album savedAlbum = albumService.saveAlbum(album);
        return new ResponseEntity<>(savedAlbum, HttpStatus.CREATED);
    }

    // Get all albums
    @GetMapping
    public ResponseEntity<List<Album>> getAllAlbums() {
        List<Album> albums = albumService.getAllAlbums();
        return new ResponseEntity<>(albums, HttpStatus.OK);
    }

    // Get an album by ID
    @GetMapping("/{id}")
    public ResponseEntity<Album> getAlbumById(@PathVariable("id") int albumId) {
        Album album = albumService.getAlbumById(albumId);
        return album != null ? new ResponseEntity<>(album, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Update an album
    @PutMapping("/{id}")
    public ResponseEntity<Album> updateAlbum(@PathVariable("id") int albumId, @RequestBody Album albumDetails) {
        Album album = albumService.getAlbumById(albumId);
        if (album != null) {
            album.setAlbumName(albumDetails.getAlbumName());
            album.setAlbumDescription(albumDetails.getAlbumDescription());
            album.setStartDate(albumDetails.getStartDate());
            album.setEndDate(albumDetails.getEndDate());
            album.setAlbumIsActive(albumDetails.isAlbumIsActive());
            Album updatedAlbum = albumService.updateAlbum(album);
            return new ResponseEntity<>(updatedAlbum, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete an album
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteAlbum(@PathVariable("id") int albumId) {
        albumService.deleteAlbum(albumId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}