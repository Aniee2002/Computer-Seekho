package com.Project.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
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
    public void addVideo(Video v)
    {
        videoService.addVideo(v);
    }

    @GetMapping("/all")
    public void getAllVideos()
    {
        videoService.getAllVideos();
    }

    @DeleteMapping("/delete/{videoId}")
    public void delete(@PathVariable int videoId)
    {
        videoService.delete(videoId);
    }

    @PutMapping("/activate/{videoId}/{videoIsActive}")
    public void activateVideo(@PathVariable int videoId,@PathVariable Boolean videoIsActive)
    {
        videoService.activateVideo(videoId, videoIsActive);
    }
    

}
