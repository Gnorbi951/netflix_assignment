package com.codecool.videoservice.service;

import com.codecool.recommendation.entity.Recommendation;
import com.codecool.recommendation.service.RecommendationManager;
import com.codecool.videoservice.entity.Video;
import com.codecool.videoservice.repository.VideoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Service
@Slf4j
public class VideoManager {

    @Autowired
    VideoRepository videoRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${videorecommendation.url}")
    private String baseUrl;

    public List<Video> retrieveAllVideos() {
        return videoRepository.findAll();
    }

    public List<Recommendation> findVideoWithRecommendations(Long id) throws IOException {

        Video foundVideo = findVideoById(id);
        // Kill any type of bad requests here
        if (foundVideo == null) return null;

        List<Recommendation> recommendations = restTemplate.getForEntity(baseUrl + "find-by-id/" + id, List.class).getBody();
        if (recommendations.size() == 0) recommendations = null;

        return recommendations;

    }

    public Video findVideoById(Long id) {
        return videoRepository.findById(id).orElse(null);
    }

    public void sendPostToRecommendationService(Recommendation recommendation) throws IOException {
//        CloseableHttpClient httpclient = HttpClients.createDefault();
//        //TODO: Burned in port
//
//        HttpPost httppost = new HttpPost("http://localhost:8081/recommendation-service/add-new-recommendation");
//
//        // Request parameters and other properties.
//        List<NameValuePair> params = new ArrayList<NameValuePair>(2);
//        params.add(new BasicNameValuePair("id", recommendation.getId().toString()));
//        params.add(new BasicNameValuePair("comment", recommendation.getComment()));
//        params.add(new BasicNameValuePair("rating", Integer.toString(recommendation.getRating())));
//        params.add(new BasicNameValuePair("videoId", recommendation.getVideoId().toString()));
//        httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
//
//        //Execute
//        CloseableHttpResponse response = httpclient.execute(httppost);
//        HttpEntity entity = response.getEntity();
//        System.out.println(response.toString());
//        System.out.println(entity.toString());
        
        restTemplate.postForEntity(baseUrl + "add-new-recommendation", recommendation, Recommendation.class);
    }
}
