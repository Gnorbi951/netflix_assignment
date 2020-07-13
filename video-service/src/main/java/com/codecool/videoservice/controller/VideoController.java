package com.codecool.videoservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/video-service")
public class VideoController {

    @GetMapping("/test")
    public String getAllVideos() {
        return "In production.";
    }
}
