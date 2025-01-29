package com.Project.Services;

import java.util.List;
import com.Project.Entities.Video;

public interface VideoService {
    void addVideo(Video v);
    List<Video> getAllVideos();
    void delete(int videoId);
    void activateVideo(int videoId,Boolean videoIsActive);
}
