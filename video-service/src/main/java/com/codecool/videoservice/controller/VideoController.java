package com.codecool.videoservice.controller;

import com.codecool.videoservice.entity.Video;
import com.codecool.videoservice.service.VideoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/video-controller")
public class VideoController {

    @Autowired
    VideoManager videoManager;

    @GetMapping("/all")
    public List<Video> getAllVideos() {
        return videoManager.retrieveAllVideos();
    }
}
