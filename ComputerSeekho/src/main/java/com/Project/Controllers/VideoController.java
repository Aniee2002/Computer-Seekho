package com.Project.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Project.Entities.Video;
import com.Project.Services.VideoService;

@RestController
@RequestMapping("/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @PostMapping("/add")
    public ResponseEntity<Video> addVideo(Video v) {
        videoService.addVideo(v);
        return ResponseEntity.ok(v);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Video>> getAllVideos() {
        List<Video> video = videoService.getAllVideos();
        return ResponseEntity.ok(video);
    }

    @DeleteMapping("/delete/{videoId}")
    public String delete(@PathVariable int videoId) {
        videoService.delete(videoId);
        return "Video Deleted";
    }

    @PutMapping("/activate/{videoId}/{videoIsActive}")
    public Boolean activateVideo(@PathVariable int videoId, @PathVariable Boolean videoIsActive) {
        videoService.activateVideo(videoId, videoIsActive);
        return videoIsActive;
    }

}
