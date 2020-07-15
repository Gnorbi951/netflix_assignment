package com.codecool.videoservice;

import com.codecool.videoservice.entity.Video;
import com.codecool.videoservice.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
public class VideoServiceApplication {

    @Autowired
    VideoRepository videoRepository;

    public static void main(String[] args) {
        SpringApplication.run(VideoServiceApplication.class, args);
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

//    @Bean
//    @LoadBalanced
//    public RestTemplate restTemplate() {
//        return new RestTemplate();
//    }

    @Bean
    public CommandLineRunner init() {
        return args -> {

            Video video1 = Video.builder()
                    .name("Daft Punk- Veridis Quo Extended/Loop")
                    .viewKey("Q-oU-iqBZGc")
                    .build();
            Video video2 = Video.builder()
                    .name("Daft Punk Feat Pharrel Williams - Get Lucky (Album Version Video)")
                    .viewKey("XkeIwhKIi84")
                    .build();
            Video video3 = Video.builder()
                    .name("Daft Punk ft. Julian Casablancas - Instant Crush (Official Video)")
                    .viewKey("a5uQMwRMHcs")
                    .build();
            Video video4 = Video.builder()
                    .name("Gyóntatófülke - Koronavírust megelőző csoronita mix")
                    .viewKey("MEW6n2vz1qw")
                    .build();


            videoRepository.saveAll(Arrays.asList(video1, video2, video3, video4));

        };
    };


}
